<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ include file="./include/header.jsp"%>
<html>
<head>
</head>
<body>
<h1>
	게시판
</h1>
<table class="table">
	
	<tbody>
		<tr>
		<td>글제목</td>							
		<td>${vo.title}</td>	
		</tr>

		<tr>
		<td>작성자</td>							
		<td>${vo.user_name}</td>	
		</tr>
		
		<tr>
		<td>내용</td>										
		<td>${vo.content}</td>		
		</tr>
		
		<tr>
		<td>작성일</td>										
		<td>${vo.regdate}</td>		
		</tr>
		
		<tr>
		<td>조회수</td>										
		<td>${vo.view_cnt}</td>		
		</tr>
	</tbody>
</table>

<form action="/rest/${vo.board_no}" method="POST">
	<input type="hidden" id="_method" name="_method" value="delete"/>
	<input type="submit" id="btn"  value="삭제"/>		
</form>

<h3>덧글</h3>

<div id ="reply_list"></div>
<div id ="reply_page"></div>
<form id="reply">
<input type="text" id="content" name="content" size="50"/>
, 작성자: <input type="text" id="user_name" name="user_name" size="10"/>
<input type="button" id="btn2" onclick="insertReply()" value="등록"/>
</form>	

<script>

	var bno = '${vo.board_no}';   		// tip???자바스크립트에서 변수를 지정할 때 문자열로 감싸면 에러가 발생되지 않음???
	var currentRage = 1;

/*========= Reply delete =========  */				
	function deleteReply(rno) {

		$.ajax({
			type:'delete',
			url: '/reply/' + rno,
			headers: {"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			data: '',
			dataType:'text',
			success : function(result){
				if(result =="SUCCESS"){
					getReplyList();	
				}
			}
		});
		
	}

			
			
/*========= Reply Insert =========  */	
	function insertReply(){
		
//		var reply_form 		= document.getElementById("reply");		
		var reply_content 	= $("#content").val();					//댓글내용( reply_from.content)
		var reply_user 		= $("#user_name").val();				//댓글작성자(reply_from.user_name)
		
		$.ajax({
			type:'post',
			url: "/reply/" + bno,
			headers: {"Content-Type" : "application/json"},
			dataType: 'text',
			data : '{"content":"'+reply_content+'", "user_name":"'+reply_user+'"}',   // JSON.strigify({content:reply_content, user_name:reply_user}),
			success:	function(result) {
				if(result == "SUCCESS"){
					getReplyList();	
				}
			}
		});
	}

/*========= Reply Set List =========  */
	function setReplyList(list) {	
	var result= "<ul>";		
		
		$(list).each(function(){								// 반복하여 출력
			result += "<li>" 
			+ this.content +":		"+ this.user_name
			+"<input type='button' value='삭제' onclick='deleteReply("
				+ this.reply_no 
				+ ")'/>"
			+"</li>";
		});
		
		result +="</ul>";	
		document.getElementById("reply_list").innerHTML = result; 
	}

/*========= Reply Get List =========  */	
	function getReplyList(page) {	
	
		if(page ==null){
			page = currentPage;
		}
		
		$.ajax({
			type:'get',
			url: '/reply/' + bno + '/' + page,
			headers: {"Content-Type" : "application/json", 
							"X-HTTP-Method-Override" : "GET"
							},
			dataType: 'json',
			data : '',
			success:	function(result) {
				setReplyList(result.l);
				setPagePrint(result.p);
				
			}
		});
		currentPage = p.criteria.page;
	}
	getReplyList(1);
	
	
/*========= Reply page =========  */	
	function setPagePrint(pm){
		var str = "<ul class='pagination'>";
		
		if(pm.prev)
			str += "<li><a onclick='getReplyList("+(pm.startPage-1)+")' &lt;</a> </li>"
		
		for(var i = pm.startPage ;  i <= pm.endPage ; i++){
			if(i == pm.criteria.page){
				str += "<li class='active'><a href='#'>" + i + "</li>";	
			}else{
			str += "<li><a onclick='getReplyList("+i+")' style='cursor:hand'>" + i + "</a></li>";
			}	
		}	
			
		if(pm.next)
			str += "<li><a onclick='getReplyList("+(pm.endPage+1)+")' &gt; </a></li>"
		
		str += "</ul>";	
			
			document.getElementById("reply_page").innerHTML = str;
	}
	getReplyList(currentPage);
</script>


</body>
<%@ include file="./include/footer.jsp"%>
</html>
