/** [아이디] 공백, 길이, 정규식 검증 **/
var idTest = function() {
	var idVal = $("#id").val();
	
	// 공백 검증
	if(idVal.trim().length == 0) {
		alert("아이디를 입력하세요.");
		$('#id').focus();
		return false;
	}
	
	// 길이 검증
	if(idVal.trim().length < 4 || idVal.length > 12) {
		alert("아이디는 4~12글자로 입력하세요.");
		$('#id').focus();
		return false;
	}
	
	// 정규식 검증
	// ex) 영문소문자로 시작하고 한개 이상의 숫자와 영문자의 조합
	var regId = /^[a-z]+[0-9a-zA-Z]{3,11}$/;
	if( !(regId.test(idVal)) ) {
		alert("아이디 형식 오류입니다.");
		$('#id').focus();
		return false;
	}
	
	// 모든 검증 완료
	return true;
}

/** [동] 공백 검증 **/
var dongTest = function() {
	var dongVal = $("#dong").val();
	
	// 공백 검증
	if(dongVal.trim().length == 0) {
		alert("동을 입력하세요.");
		$("#dong").focus();
		return false;
	}
	
	// 모든 검증 완료
	return true;
}


/** [이름/비번/전번/메일] 공백, 길이, 정규식 검증 **/
var regTest = function() {

	/**************************************** 이름 ****************************************/
	var nameVal = $("#name").val().trim();
	
	// 이름 공백 검증
	if(nameVal.length == 0) { 
		alert("이름을 입력하세요.");
		$("#name").focus();
		return false;
	}
	
	// 이름 정규식, 길이 검증
	var regName = /^[가-힝]+|^[a-zA-Z]+/;
	if(regName.test(nameVal)) {
		var regKor = /^[가-힝]+$/;	// 한글이름 정규식
		var regEng = /^[a-zA-Z]+$/;	// 영문이름 정규식
		
		if(regKor.test(nameVal)) {
			// 한글이름 길이 검증(2~5자)
			if(nameVal.length < 2 || nameVal.length > 5) {
				alert("한글이름은 2~5글자로 입력하세요.");
				$("#name").focus();
				return false;
			}
		} else if(regEng.test(nameVal)) {
			// 한글이름 길이 검증(5~20자)
			if(nameVal.length < 5 || nameVal.length > 20) {
				alert("영문이름은 5~20글자로 입력하세요.");
				$("#name").focus();
				return false;
			}
		} else {
			alert("이름 형식 오류입니다.");
			$('#name').focus();
			return false;
		}
	} else {
		alert("이름 형식 오류입니다.");
		$('#name').focus();
		return false;
	}
	
	/**************************************** 비밀번호 ****************************************/
	var passVal = $("#pass").val().trim();
	
	// 비밀번호 공백 검증
	if(passVal.length == 0) { 
		alert("비밀번호를 입력하세요.");
		$("#pass").focus();
		return false;
	}
	
	// 비밀번호 길이 검증(8~12자)
	if(passVal.length < 8 || passVal.length > 12) {
		alert("비밀번호는 8~12글자로 입력하세요.");
		$("#pass").focus();
		return false;
	}
	
	// 비밀번호 정규식 검증(숫자, 영문 대소문자, 특수문자가 반드시 한개이상씩 포함)
//	reg = /\w+(?=:)/; // ?=: 전방탐색

	// 0번 이상 나오는 문자뒤에 a-z를 기준으로 전방에 아무것도 없다, 그래서 a-z로 시작
	// 0번 이상 나오는 문자뒤에 A-Z를 기준으로 전방에 아무것도 없다, 그래서 A-Z로 시작
	// 0번 이상 나오는 문자뒤에 0-9를 기준으로 전방에 아무것도 없다, 그래서 0-9로 시작
	// 0번 이상 나오는 문자뒤에 !@#$%^&*()+_-를 기준으로 전방에 아무것도 없다, 그래서 !@#$%^&*()+_-로 시작
	var regPass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()+_-]).{8,12}$/;  
	if(!(regPass.test(passVal))) {
		alert("비밀번호 형식 오류입니다.");
		$("#pass").focus();
		return false;
	}
	
	/**************************************** 전화번호 ****************************************/
	var hpVal = $("#hp").val().trim();
	
	// 전화번호 공백 검증
	if(hpVal.length == 0) {
		alert("전화번호를 입력하세요.");
		$("#hp").focus();
		return false;
	}
	
	// 전화번호 정규식 검증
	var regHp = /\d{3}-\d{4}-\d{4}/;
	if(!(regHp.test(hpVal))) {
		alert("전화번호 형식 오류입니다.");
		$("#hp").focus();
		return false;
	}
	
	/**************************************** 이메일 ****************************************/
	var mailVal = $("#mail").val().trim();
	
	// 이메일 공백 검증
	if(mailVal.length == 0) {
		alert("이메일을 입력하세요.");
		$("#mail").focus();
		return false;
	}
	
	// 이메일 정규식 검증
	var regMail = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+){1,2}$/;
	if(!(regMail.test(mailVal))) {
		alert("이메일 형식 오류입니다.");
		$("mail").focus();
		return false;
	}
	
	/**************************************** 모든 검증 통과 ****************************************/
	return true;
	
}