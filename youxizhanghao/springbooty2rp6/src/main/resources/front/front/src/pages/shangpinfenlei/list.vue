<template>
<div>
	<div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="list-preview" :style='{"width":"1200px","margin":"10px auto","position":"relative","flexWrap":"wrap","background":"none","display":"flex"}'>
		
	
    <el-form :inline="true" :model="formSearch" class="list-form-pv" :style='{"padding":"10px","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto","order":"2"}'>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>账号分类</div>
        <el-input v-model="formSearch.shangpinfenlei" placeholder="账号分类" clearable></el-input>
      </el-form-item>
	  <el-button v-if=" true " :style='{"cursor":"pointer","border":"1px solid #21a63d","padding":"0px 15px","boxShadow":"1px 1px 3px #21a63d","margin":"0px 10px 0 0","color":"#fff","outline":"none","borderRadius":"4px","background":"#25bd45","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}' type="primary" @click="getList(1, curFenlei)"><i v-if="true" :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-search"></i>查询</el-button>
	  <el-button v-if="isAuth('shangpinfenlei','新增')" :style='{"cursor":"pointer","border":"1px solid #db961f","padding":"0px 15px","boxShadow":"1px 1px 3px #f8a412","margin":"0px 10px 0 0","color":"#fff","outline":"none","borderRadius":"4px","background":"#f8a412","width":"auto","fontSize":"14px","lineHeight":"40px","height":"40px"}' type="primary" @click="add('/index/shangpinfenleiAdd')"><i v-if="true" :style='{"color":"#fff","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-circle-plus-outline"></i>添加</el-button>
    </el-form>

	<div class="list" :style='{"width":"100%","margin":"0 0 10px","background":"none","order":"3"}'>
		<!-- 样式一 -->
		<div class="list1 index-pv1" :style='{"border":"1px solid #dfdfdf","padding":"20px 10px","margin":"16px 0 0 0","borderRadius":"16px","flexWrap":"wrap","background":"#fff","display":"flex","width":"1200px","height":"auto"}'>
			<div :style='{"margin":"0 1% 20px 1%","borderRadius":"8px","background":"none","display":"inline-block","width":"23%","position":"relative","height":"auto"}' v-for="(item, index) in dataList" :key="index" @click="toDetail(item)" class="list-item animation-box">
				<div v-if="item.price" :style='{"padding":"0 10px","boxShadow":"1px 1px 1px #ddd","margin":"4px 0 0 0","color":"red","borderRadius":"8px","background":"radial-gradient(circle, rgba(250,250,250,1) 0%, rgba(220,230,250,0.5) 100%)","lineHeight":"30px","fontSize":"14px"}' class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{item.price}}</div>
			</div>
		</div>
		
		<!-- 样式二 -->
	</div>

	
	<el-pagination
	  background
	  class="pagination"
	  :pager-count="7"
	  :page-size="pageSize"
	  :page-sizes="pageSizes"
	  prev-text="<"
	  next-text=">"
	  :hide-on-single-page="true"
	  :layout='["total","prev","pager","next","sizes","jumper"].join()'
	  :total="total"
	  :style='{"padding":"0","margin":"10px auto","whiteSpace":"nowrap","color":"#333","width":"1200px","fontWeight":"500","order":"4"}'
	  @current-change="curChange"
	  @prev-click="prevClick"
	  @next-click="nextClick"
	></el-pagination>

  </div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
	    layouts: '',
		swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '账号分类'
          }
        ],
        formSearch: {
          shangpinfenlei: '',
        },
        fenlei: [],
        dataList: [],
        total: 1,
        pageSize: 10,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
        timeRange: []
      }
    },
    created() {
      this.indexQueryCondition = this.$route.query.indexQueryCondition ? this.$route.query.indexQueryCondition : '';
      this.baseUrl = this.$config.baseUrl;
      this.getFenlei();
      this.getList(1, '全部');
    },
    //方法集合
    methods: {
      add(path) {
        this.$router.push({path: path});
      },
      getFenlei() {
      },
      getList(page, fenlei, ref = '') {
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.shangpinfenlei != '') searchWhere.shangpinfenlei = '%' + this.formSearch.shangpinfenlei + '%';
        this.$http.get('shangpinfenlei/list', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.dataList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;
            this.totalPage = res.data.data.totalPage;
			
			this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
          }
        });
      },
      curChange(page) {
        this.getList(page);
      },
      prevClick(page) {
        this.getList(page);
      },
      nextClick(page) {
        this.getList(page);
      },
      toDetail(item) {
        this.$router.push({path: '/index/shangpinfenleiDetail', query: {detailObj: JSON.stringify(item)}});
      },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview .list-form-pv .el-input {
		width: auto;
	}

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #ccc;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
		color: #333;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
		color: #999;
		display: inline-block;
	}
	
	.category-1 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		overflow: hidden;
		color: #555;
		white-space: nowrap;
		background: url(http://codegen.caihongy.cn/20221028/c2a267fc2ff947eebee5c76b939bb3af.png) no-repeat;
		width: 130px;
		font-size: 14px;
		line-height: 40px;
		text-overflow: ellipsis;
		text-align: center;
	}
	
	.category-1 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #fff;
		background: url(http://codegen.caihongy.cn/20221028/72abcc9e5f8b4702967f0558d2183d22.png) no-repeat;
		width: 130px;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
	}
	
	.category-1 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #fff;
		background: url(http://codegen.caihongy.cn/20221028/72abcc9e5f8b4702967f0558d2183d22.png) no-repeat;
		width: 130px;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
	}
	
	.category-2 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid #ccc;
		border-radius: 8px;
		padding: 0 10px;
		box-shadow: 1px 1px 1px #ccc;
		margin: 0px;
		outline: none;
		color: #666;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
		border: 1px solid #ccc;
		border-radius: 8px;
		padding: 0 10px;
		box-shadow: 1px 1px 1px #ccc;
		margin: 0px;
		outline: none;
		color: #666;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #ccc;
		border-radius: 8px;
		padding: 0 30px;
		box-shadow: 1px 1px 1px #ccc;
		margin: 0px;
		outline: none;
		color: #666;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
	}
	
	.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #409EFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #409EFF;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
</style>
