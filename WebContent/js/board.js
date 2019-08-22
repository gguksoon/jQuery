var readServer = function() {
	$.ajax({
				url: "/jqpro/BoardSelect",
				type: "get",
				dataType: "json",
				success: function(datas) {
					code = '<div class="panel-group" id="parent">';
					
					$.each(datas, function(i, v) {
						code += '<div class="panel panel-default">';
					    code += '  <div class="panel-heading">';
					    code += '    <h4 class="panel-title">';
					    code += '      <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.seq +'">'+ v.subject +'</a>';
					    code += '    </h4>';
					    code += '  </div>';
					    code += '  <div id="collapse'+ v.seq +'" class="panel-collapse collapse">'; // class에 in클래스를 주면 펼쳐짐
					    code += '    <div class="panel-body">';
					    code += '    	<p style="width: 80%; float: left;">';
					    code += '    		작성자: '+ v.writer + ', 이메일: ' + v.mail +', 작성일: '+ v.wdate +', 조회수: ' + v.hit;
					    code += '    	</p>';
					    code += '    	<p style="float: right">';
					    code += '    		<button data-idx="'+ v.seq +'" type="button" name="modify"  class="btn btn-default btn-sm" >수정</button>';
					    code += '    		<button data-idx="'+ v.seq +'" type="button" name="delete"  class="btn btn-default btn-sm" >삭제</button>';
					    code += '    	</p>';
					    code += '    	<br>';
					    code += '    	<hr>';
					    code += '    	<p style="width: 80%; float: left;">';
					    code +=     		v.content;
					    code += '    	</p>';
					    code += '    	<br>';
					    code += '    	<hr>';
					    code += '    	<p style="width: 80%; float: left">';
					    code += '    		<textarea class="area" cols="100" style="width: 85%; float: left">댓글</textarea>&nbsp';
					    code += '    		<button style="height: 45px; vertical-align: top;" type="button" data-idx="'+ v.seq +'" name="reply"  class="btn btn-default btn-sm" >작성</button>';
					    code += '    	</p>';
					    code += '    </div>';
					    code += '  </div>';
					    code += '</div>';
					})
					
				    code += '</div>';
				    $("#accordionList").html(code);
				},
				error: function(xhr) {
					alert("상태: " + xhr.status);
				}
				
			})
}

var writeServer = function() {

	$.ajax({
		url: "/jqpro/BoardWrite",
		type: "post",
		data: $("#writeForm").serializeArray(),
		dataType: "json",
		success: function(data) {
			$("#ss").html(data);
			$("#myModal").modal("hide");
			alert(data.res);
		},
		error: function(xhr) {
			alert("상태: " + xhr.status);
		}
	})
}
