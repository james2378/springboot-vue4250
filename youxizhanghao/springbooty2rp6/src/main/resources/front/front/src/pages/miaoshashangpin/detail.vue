<template>
<div>
	<div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	
	<div class="detail-preview" :style='{"width":"1200px","padding":"0 0 24px","margin":"0px auto","position":"relative"}'>
		<div class="attr" :style='{"border":"1px solid #dfdfdf","padding":"16px 16px 20px 16px","boxShadow":"1px 2px 3px #eee","margin":"20px 0 20px 0","overflow":"hidden","borderRadius":"16px","background":"#fff","position":"relative"}'>
			<el-carousel :style='{"width":"540px","margin":"0 0px 0 0","float":"right","height":"400px"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="400px" autoplay="true" interval="3000" loop="true">
				<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-for="item in detailBanner" :key="item.id">
					<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="item.substr(0,4)=='http'" :src="item" fit="cover" class="image"></el-image>
					<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-else :src="baseUrl + item" fit="cover" class="image"></el-image>
				</el-carousel-item>
			</el-carousel>
	
			
			<div class="info" :style='{"minHeight":"520px","width":"600px","padding":"0px 0 20px","margin":"0px","float":"left","background":"#fff"}'>
				<div class="item" :style='{"border":"0px solid #eee","padding":"10px 10px","boxShadow":"1px 2px 6px #8dd2eb","margin":"0 0 10px 0","alignItems":"center","borderRadius":"8px","background":"radial-gradient(circle, rgba(55,170,250,1) 25%, rgba(63,94,251,1) 100%),rgb(63,201,251)","display":"flex","justifyContent":"space-between"}'>
					<div :style='{"color":"#fff","fontSize":"16px"}'>
                    {{detail.shangpinmingcheng}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"cursor":"pointer","padding":"0","borderRadius":"30%","background":"none"}'><i v-if="true" :style='{"color":"#ffb966","fontSize":"14px"}' class="el-icon-star-off"></i><span :style='{"color":"#ffb966","fontSize":"14px"}'>点我收藏</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"cursor":"pointer","padding":"0","borderRadius":"30%","background":"none"}'><i v-if="true" :style='{"color":"#ffb966","fontSize":"14px"}' class="el-icon-star-on"></i><span :style='{"color":"#ffb966","fontSize":"14px"}'>取消收藏</span></div>
				</div>

				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>限时秒杀</div>
					<count-down v-if="endTime&&startTime"
						:style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'
						:startTime="startTime"
						:endTime="endTime"
						:tipText="'距离开始 '"
						tipTextEnd="距离结束 "
						endText="活动已结束"
						dayTxt="天 "
						hourTxt="小时 "
						minutesTxt="分钟 "
						secondsTxt="秒">
					</count-down>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}' v-if="detail.price">
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>价格</div>
					<div style="font-weight: bold;" :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'><span :style='{"fontSize":"12px"}'>￥</span>{{detail.price}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}' v-if="detail.jf">
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>积分</div>
					<div style="color: red;font-weight: bold;" :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.jf}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>单次购买</div>
					<div :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.onelimittimes}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>库存</div>
					<div :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.alllimittimes}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>账号分类</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.shangpinfenlei}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>品牌</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.pinpai}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>账号</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.zhanghao}}</div>
				</div>
				<div class="item" :style='{"border":"1px solid #dfdfdf","padding":"0px 10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"radial-gradient(circle, rgba(246,246,246,1) 0%, rgba(230,230,230,1) 100%)","display":"flex","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"width":"120px","padding":"0 10px","fontSize":"14px","lineHeight":"40px","color":"#666","textAlign":"right"}'>上架日期</div>
					<div  :style='{"width":"498px","padding":"8px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#999","height":"auto"}'>{{detail.shangjiariqi}}</div>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
					<el-input-number :style='{"width":"180px","margin":"0 5px 0 0","lineHeight":"38px","position":"relative","display":"inline-block"}' v-if="detail.alllimittimes" v-model="buynumber"></el-input-number>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="detail.alllimittimes" type="warning" size="small" @click="addCart">添加到购物车</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="detail.alllimittimes" type="warning" size="small" @click="buyNow">立即购买</el-button>
				</div>
				<div class="btn" :style='{"padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
				</div>
			</div>
			
		</div>
		
		
		<el-tabs class="detail" :style='{"border":"1px solid #dfdfdf","minHeight":"350px","boxShadow":"1px 2px 3px #eee","padding":"16px","borderRadius":"16px","background":"#FFF"}' v-model="activeName" type="border-card">
			<el-tab-pane label="账号详情" name="first">
				<div v-html="detail.shangpinxiangqing"></div>
			</el-tab-pane>
			<el-tab-pane label="评论" name="second">
				<el-form class="add comment" :style='{"padding":"0px","margin":"12px 0 20px"}' :model="form" :rules="rules" ref="form">
					<el-form-item class="item" :style='{"border":"1px solid #ccc","boxShadow":"inset 0px 0px 28px 0px #eee","borderRadius":"8px","background":"#fff","display":"flex","width":"100%","height":"auto"}' label="评论" prop="content">
						<el-input type="textarea" :rows="5" v-model="form.content" placeholder="请输入内容"></el-input>
					</el-form-item>
					<el-form-item class="btn" :style='{"width":"100%","padding":"0 0 0 20px","margin":"10px 0 0","height":"auto"}'>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"1px 2px 6px #52a1db","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","outline":"none","borderRadius":"30%","background":"radial-gradient(circle, rgba(128,184,246,1) 0%, rgba(36,153,251,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="submitForm('form')">立即提交</el-button>
						<el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"1px 2px 6px #ccc","margin":"0 20px 0 0","color":"#999","outline":"none","borderRadius":"30%","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="resetForm('form')">重置</el-button>
					</el-form-item>
				</el-form>
				
				<div v-if="infoList.length" :style='{"boxShadow":"0 0px 0px 0 rgba(0, 0, 0, .1)","padding":"15px"}' class="comment">
					<div :style='{"padding":"0px 0","margin":"0 0 8px","borderColor":"#bbb","alignItems":"center","borderWidth":"0 0 1px 0","width":"100%","borderStyle":"dotted","height":"auto"}' v-for="item in infoList" :key="item.id">
						<div class="user" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
							<el-image v-if="item.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :size="50" :src="baseUrl + item.avatarurl"></el-image>
							<el-image v-if="!item.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :size="50" :src="require('@/assets/touxiang.png')"></el-image>
							<div :style='{"color":"#333","fontSize":"16px"}' class="name">{{item.nickname}}</div>
						</div>
						<div :style='{"padding":"8px","margin":"8px 0px 0px","color":"#666","borderRadius":"4px","background":"none","lineHeight":"24px","fontSize":"14px","textIndent":"2em"}' class="content-block-ask">
							{{item.content}}
						</div>
						<div :style='{"padding":"8px","margin":"8px 0px 0px","color":"#666","borderRadius":"4px","background":"none","lineHeight":"24px","fontSize":"14px","textIndent":"2em"}' class="content-block-reply" v-if="item.reply">
							回复：{{item.reply}}
						</div>
					</div>
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
			</el-tab-pane>
			
		</el-tabs>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  export default {
    //数据集合
    data() {
      return {
        tablename: 'miaoshashangpin',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '详情信息'
          }
        ],
        title: '',
        detailBanner: [],
        endTime: 0,
        detail: {},
        activeName: 'first',
        form: {
          content: '',
          userid: localStorage.getItem('userid'),
          nickname: localStorage.getItem('username'),
          avatarurl: '',
        },
        infoList: [],
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ]
        },
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'miaoshashangpin',
          userid: localStorage.getItem('userid')
        },
        isStoreup: false,
        storeupInfo: {},
        buynumber: 1,
        cart: {
          buynumber: 0,
          discountprice: 0,
          goodid: 0,
          goodname: '',
          picture: '',
          price: 0,
          userid: localStorage.getItem('userid')
        },
        isInCart: false,
      }
    },
    created() {
        this.init();
    },
    //方法集合
    methods: {
        init() {
          this.baseUrl = this.$config.baseUrl;
          if(this.$route.query.detailObj) {
            this.detail = JSON.parse(this.$route.query.detailObj);
          }
          if(this.$route.query.storeupObj) {
            this.detail.id = JSON.parse(this.$route.query.storeupObj).refid;
          }
          if(this.$route.query.discussObj) {
            this.detail.id = JSON.parse(this.$route.query.discussObj).goodid;
          }
          this.$http.get(this.tablename + '/detail/'  + this.detail.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.title = this.detail.shangpinmingcheng;
              this.detailBanner = this.detail.tupian ? this.detail.tupian.split(",") : [];
              this.startTime = new Date().getTime();
              this.endTime = new Date(this.detail.reversetime).getTime();
              this.$forceUpdate();
            }
          });

          this.getDiscussList(1);
          this.getStoreupStatus();
          this.getCartList();

        },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.inteltype = this.detail.shangpinfenlei;
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          let delIds = new Array();
          delIds.push(this.storeupInfo.id);
          this.$http.post('storeup/delete', delIds).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = false;
              this.$message({
                type: 'success',
                message: '取消成功!',
                duration: 1500,
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("Token")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'miaoshashangpin', userid: localStorage.getItem('userid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
      // 下载
      download(file){
        if(!file) {
            this.$message({
              type: 'error',
              message: '文件不存在',
              duration: 1500,
            });
            return;
        }
        window.open(this.baseUrl+file)
      },
      getDiscussList(page) {
        this.$http.get('discussmiaoshashangpin/list', {params: {page, limit: this.pageSize, refid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      submitForm(formName) {
        let sensitiveWords = "";
        let sensitiveWordsArr = [];
        if(sensitiveWords) {
            sensitiveWordsArr = sensitiveWords.split(",");
        }
        for(var i=0; i<sensitiveWordsArr.length; i++){
            //全局替换
            var reg = new RegExp(sensitiveWordsArr[i],"g");
            //判断内容中是否包括敏感词
            if (this.form.content.indexOf(sensitiveWordsArr[i]) > -1) {
                // 将敏感词替换为 **
                this.form.content = this.form.content.replace(reg,"**");
            }
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get('orders/list', {params: {page: 1, limit: 1, status: '已完成', goodid: this.detail.id, userid: localStorage.getItem('userid')}}).then(res => {
                if (res.data.code == 0 && res.data.data.list.length == 0) {
                  this.$message({
                    type: 'success',
                    message: '请完成订单后再评论!',
                    duration: 1500
                  });
                  return false
                } else {
                    this.form.refid = this.detail.id;
                    this.form.avatarurl = localStorage.getItem('headportrait')?localStorage.getItem('headportrait'):'';
                    this.$http.post('discussmiaoshashangpin/add', this.form).then(res => {
                      if (res.data.code == 0) {
                        this.form.content = '';
                        this.getDiscussList(1);
                        this.$message({
                          type: 'success',
                          message: '评论成功!',
                          duration: 1500,
                        });
                      }
                    });
                }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      getCartList() {
        this.$http.get('cart/list', {params: {userid: localStorage.getItem('userid'), tablename: 'miaoshashangpin', goodid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            if (res.data.data.list.length > 0) {
              this.isInCart = true;
            } else {
              this.isInCart = false;
            }
          }
        });
      },
      addCart() {
        if(new Date().getTime() > new Date(this.detail.reversetime).getTime()) {
          this.$message.error('活动已结束');
          return;
        }
            // 单次购买限制
            if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
                this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
                return
            }
            // 库存不够
            if (this.detail.alllimittimes <= 0 ) {
                this.$message.error(`账号已售罄`);
                return
            }
            // 库存限制
            if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
                this.$message.error(`库存不足`);
                return
            }
        if (this.isInCart) {
          this.$message.error('该账号已经添加到购物车');
          return;
        }

        this.cart.buynumber = this.buynumber;
        this.cart.goodid = this.detail.id;
        this.cart.goodname = this.title;
        this.cart.tablename = this.tablename;
        this.cart.zhanghao = this.detail.zhanghao;
        this.cart.goodtype = this.detail.shangpinfenlei;
        this.cart.picture = this.detailBanner[0];
        this.cart.price = this.detail.price;
        this.$http.post('cart/save', this.cart).then(res => {
          if (res.data.code === 0) {
            this.getCartList();
            this.$message({
              message: '添加成功',
              type: 'success',
              duration: 1500,
            });
          } else {
            this.$message.error(res.data.msg);
          }
        });
      },
        //立即购买
        buyNow() {
        if(new Date().getTime() > new Date(this.detail.reversetime).getTime()) {
          this.$message.error('活动已结束');
          return;
        }
            // 单次购买限制
            if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
                this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
                return
            }
            // 库存不够
            if (this.detail.alllimittimes <= 0 ) {
                this.$message.error(`账号已售罄`);
                return
            }
            // 库存限制
            if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
                this.$message.error(`库存不足`);
                return
            }
            // 保存到storage中，在确认下单页面中获取要购买的账号
            localStorage.setItem('orderGoods', JSON.stringify([{
                tablename: this.tablename,
                goodid: this.detail.id,
                goodname: this.title,
                zhanghao: this.detail.zhanghao,
                goodtype: this.detail.shangpinfenlei,

                picture:this.detailBanner[0],
                buynumber: this.buynumber,
                userid: localStorage.getItem('userid'),
                price: this.detail.price,
                discountprice: this.detail.vipprice ? this.detail.vipprice : 0
            }]));
            // 跳转到确认下单页面
            let query = {
                type: 1,
            }
            this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
        },


    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #278bd5;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #278bd5;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 8px 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 4px 0 0 4px;
		top: 1px;
		left: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #666;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 4px 4px 0;
		top: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #666;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		border-radius: 4px;
		padding: 0 40px;
		outline: none;
		color: #666;
		background: #FFF;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		border-radius: 8px;
		padding: 4px 6px;
		margin: 0;
		background: radial-gradient(circle, rgba(63,201,251,1) 50%, rgba(63,94,251,1) 100%),rgb(63,201,251);
		border-color: #E4E7ED;
		border-width: 0 0 0px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 16px;
		margin: 0 4px 0 4px;
		color: #fff;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		line-height: 32px;
		border-radius: 50%;
		background: transparent;
		position: relative;
		list-style: none;
		height: 32px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border: 0;
		border-radius: 50%;
		padding: 0 16px;
		margin: 0 4px 0 4px;
		color: #409EFF;
		background: #f3f9fe;
		line-height: 32px;
		height: 32px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		border-radius: 50%;
		padding: 0 16px;
		margin: 0 4px 0 4px;
		color: #409EFF;
		background: #f3f9fe;
		line-height: 32px;
		height: 32px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
		border: 0;
		border-radius: 4px;
		padding: 4px 12px;
		box-shadow: 0 0 0px rgba(64, 158, 255, .5);
		outline: none;
		color: #333;
		background: none;
		width: 1058px;
		font-size: 14px;
		min-height: 200px;
		line-height: 32px;
		height: 200px;
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
