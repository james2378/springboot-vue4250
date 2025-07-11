export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除"],"menu":"商家","menuJump":"列表","tableName":"shangjia"}],"menu":"商家管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"账号分类","menuJump":"列表","tableName":"shangpinfenlei"}],"menu":"账号分类管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除","查看评论"],"menu":"账号信息","menuJump":"列表","tableName":"shangpinxinxi"}],"menu":"账号信息管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改","删除","查看评论"],"menu":"秒杀账号","menuJump":"列表","tableName":"miaoshashangpin"}],"menu":"秒杀账号管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"平台资讯","tableName":"news"},{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-form","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"账号信息列表","menuJump":"列表","tableName":"shangpinxinxi"}],"menu":"账号信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"秒杀账号列表","menuJump":"列表","tableName":"miaoshashangpin"}],"menu":"秒杀账号模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"账号信息列表","menuJump":"列表","tableName":"shangpinxinxi"}],"menu":"账号信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"秒杀账号列表","menuJump":"列表","tableName":"miaoshashangpin"}],"menu":"秒杀账号模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除","查看评论"],"menu":"账号信息","menuJump":"列表","tableName":"shangpinxinxi"}],"menu":"账号信息管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除","查看评论"],"menu":"秒杀账号","menuJump":"列表","tableName":"miaoshashangpin"}],"menu":"秒杀账号管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"appFrontIcon":"cuIcon-present","buttons":["查看","删除"],"menu":"已发货订单","tableName":"orders/已发货"},{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","发货","删除"],"menu":"已支付订单","tableName":"orders/已支付"},{"appFrontIcon":"cuIcon-explore","buttons":["查看","删除","日销量","月销量","品销量","类销量","月销额","日销额","品销额","类销额"],"menu":"已完成订单","tableName":"orders/已完成"},{"appFrontIcon":"cuIcon-pic","buttons":["查看","删除"],"menu":"已取消订单","tableName":"orders/已取消"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"账号信息列表","menuJump":"列表","tableName":"shangpinxinxi"}],"menu":"账号信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"秒杀账号列表","menuJump":"列表","tableName":"miaoshashangpin"}],"menu":"秒杀账号模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"商家","tableName":"shangjia"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
