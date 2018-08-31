/**
 * 
 */
/*이전페이지로*/
function prePage(){
		location.href="/Board/List";
	}
/*글쓰기 내용 전체 채우기 체크*/
	function fsubmit(){
		if($("#memId").val().length==0){
			alert("아이디를 써주세요.");
			$("#memId").focus();
		}else{
			if($("#memPwd").val().length==0){
				alert("비밀번호를 입력해 주세요.");
				$("#memPwd").focus();
			}else{
				if($("#Title").val().length==0){
					alert("제목을 입력하세요.");
					$("#Title").focus();
				}else{
					if($("#Cntx").val().length==0){
						alert("글내용을 입력하세요.");
						$("#Cntx").focus();
					}else{
						var frmSubmit=document.getElementById("frm");
						frmSubmit.submit();
					}
				}	
			}
		}	
	}
/*삭제체크*/	
	function checkPwd(pwd,pwdCheck){
		if(pwd.value==pwdCheck){
			alert("삭제되었습니다.");
			return true;
		}else{
			alert("비밀번호가 맞지 않습니다.");
			return false;
		}
	}