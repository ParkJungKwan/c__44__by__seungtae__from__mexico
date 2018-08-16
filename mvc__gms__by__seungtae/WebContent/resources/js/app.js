"use strict";
var $ = (()=>{
	return {
		nullChecker : x=>{
			var i = 0;
			var j = {
					checker : true,
					text : '필수입력값이 없습니다'
				};
			for (i in x) {
				if(x[i]===''){
					j.checker = false;
				}
			}
			return j;
		},
		addClass : (dom,cName)=>{
			var arr = cName.split(" ");
			  if (arr.indexOf(cName) == -1) {
			      dom.className += " " + cName;
			  }
		},
		create : (x)=>{
			return (document.getElementById(x))?
					document.getElementById(x) : 0
		},
		move : x =>{ 
			location.href = 
				x.context + '/'
				+ x.domain
				+ '.do?action='+x.action
				+ '&page='+x.page
		}
	}
})();
var common = (()=>{
	return {
		main : x=>{
			var moveAdmin = $.create("move_admin");
			if(moveAdmin !== 0){
				moveAdmin.addEventListener('click',()=>{
					/*var isAdmin = confirm('관리자입니까');
					if(isAdmin){
						var password = prompt('관리자비번을 입력바랍니다');
						if(password == 1){
							$.move({
								context: x,
								domain:"admin",
								action:"search",
								page:"main"
							});
						}else{
							alert('비번이 다릅니다');
						}
					}else{
						alert('관리자만 접근이 허용됩니다');
					}*/
					$.move({
						context: x,
						domain:"admin",
						action:"list",
						page:"main"
					});
				});
			}
			var moveLogin = $.create('move_login');
			if(moveLogin !== 0){
				moveLogin.addEventListener('click',function(){ 
					$.move({context : x,
						domain : 'member',
						action : 'move',
						page : 'login'});
				});
			}
			var moveAdd = $.create('move_add');
			if(moveAdd !== 0){
				$.create('move_add').addEventListener('click',function(){ 
					$.move({context : x,
						domain : 'member',
						action : 'move',
						page : 'add'});
					});
			}	
		}
	};
})();
var admin = (()=>{
	return {
		main : x=>{
			$.addClass(
					document.getElementById('searchBox'),
					'width80pt center'		
			);
			$.addClass(
					document.getElementById('searchWord'),
					'width100px floatRight'
			);
			$.addClass(
					document.getElementById('searchOption'),
					'floatRight '
			);
			$.addClass(
					document.getElementById('searchBtn'),
					'floatRight '
			);
			$.addClass(
					document.getElementById('contentBoxTab'),
					'width90pt center marginTop30px '
			);
			$.addClass(
					document.getElementById('contentBoxMeta'),
					'bgColorYellow '
			);
			for(var i of document.querySelectorAll('.username')){
				$.addClass(
						i,
						'cursor fontColorBlue'
				);
				i.addEventListener('click',function(){
					location.href=
						x+'/member.do?action=retrieve&'
								+'page=main&userid='+this.getAttribute('id');
						
				});
			}
			document.getElementById('searchBtn')
				.addEventListener('click',()=>{
					
					var option = document.getElementById('searchOption');
					location.href = (
						option.value === 'userid'		
					) ?
						x+'/admin.do?action=retrieve&page=memberDetail&userid='
								+document.getElementById('searchWord').value
							:
						x+'/admin.do?action=search&page=main&searchOption='
							+option.value+'&searchWord='
							+document.getElementById('searchWord').value
						;
					
				});
			for(var i of document.querySelectorAll('.pageNumber')){
				$.addClass(
						i,
						'cursor fontColorBlue'
				);
				i.addEventListener('click',function(){
					location.href=
						x+'/admin.do?action=search&'
						+'page=main&'
								+'pageNumber='
						+this.getAttribute('id');
				});
			}
			
		}
	};})();
var member = (()=>{
	var _userid,_ssn,_password,_name,_age,_roll,_teamid,_gender;
	var setUserid = (userid)=>{this._userid = userid;};
	var setSsn = (ssn)=>{this._ssn =ssn;};
	var setName = (name)=>{this._name = name;};
	var setPassword = (password)=>{this._password = password;};
	var setAge =x=>{
		var date = new Date();
		this._age = null;
	}
	var setGender =x=>{
		this.gender = null;
	}
	var getUserid =()=>{return this._userid;};
	var getSsn =()=>{return this._ssn;};
	var getName =()=>{return this._name;};
	var getPassword =()=>{return this._password;};
	var getAge =()=>{return this._age;}
	var getGender =()=>{return this._gender;}
	return {
		setUserid : setUserid,
		setName : setName,
		setSsn : setSsn,
		setPassword : setPassword,
		setGender : setGender,
		setAge : setAge,
		getName : getName,
		getAge : getAge,
		getUserid : getUserid,
		getSsn : getSsn,
		getPassword : getPassword,
		getGender : getGender,
		join : x=>{
			  	member.setAge(x);
			  	member.setGender(x);
		    },
		main : x=>{
			common.main(x);
			var loginBtn = $.create("login_btn");
			if(loginBtn !== 0){
				loginBtn
				.addEventListener('click',function(){
					var ok = $.nullChecker(
							[document.login_form.userid.value,
								document.login_form.password.value]);
					if(ok.checker){
						var form = $.create('login_form');
						if(form!==0){
							form.setAttribute('action',x+"/member.do");
							form.setAttribute('method',"post");
							var params = {
								action : 'login',
								page : 'retrieve'
							};
							for(var key in params){
								if(params.hasOwnProperty(key)){
									var hidden = document.createElement('input');
									hidden.setAttribute('type','hidden');
									hidden.setAttribute('name',key);
									alert(hidden.getAttribute('name'));
									hidden.setAttribute('value',params[key])
									alert(hidden.getAttribute('value'));
									form.appendChild(hidden);
								}
							}
							form.submit();	
						}
					}else{
						alert(ok.text);
					}
				});
			}
		}
	};
})();








