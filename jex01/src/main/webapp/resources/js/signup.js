$(function () {

    /* 가입하기 클릭 시 input 한번더 체크 */
    var useridcheck;
    var userpwcheck1;
    var userpwcheck2;
    var usernamecheck;
    var userhpcheck;

    /* submit 버튼 클릭 시 발생되는 이벤트 */
    $('#userForm').on('submit', function () {

        /* form 안에 있는 input tag를 가지고 와서 반복문 돌려 전역변수 값 초기화 */
        $('#userForm').find(':input').each(function () {

            if (this.id == 'userId') {
                userIdCheck(this.value);
            } else if (this.id == 'userPw1' || this.id == 'userPw2') {
                userPwCheck(this.value, this.id);
            } else if (this.id == 'userName') {
                userNameCheck(this.value);
            } else if (this.id == 'userHp') {
                userHpCheck(this.value);
            }

        });

        /* 전역변수에 저장된 boolean 값을 가지고 모두 true시 submit 실행 */
        if (useridcheck == true && userpwcheck1 == true
            && usernamecheck == true && userpwcheck2 == true && userhpcheck == true) {
            return true;
        }
        return false;
    });

    /* input tag focus를 빠져나올 시 발생되는 이벤트*/
    $('.regform').on("blur", function () {

        var value = $(this).val();
        var id = $(this).attr('id');

        switch (id) {
            case "userId":
                ajaxuserid(value);
                break;
            case "userPw1":
                userPwCheck(value, id);
                break;
            case "userPw2":
                userPwCheck(value, id);
                break;
            case "userHp":
                userHpCheck(value);
                break;
        }
    });

    /* id가 userPw2인 input tag 값 입력 시 발생되는 이벤트 */
    $('#userPw2').on("keypress", function () {

        $('#pwMsg2').css('display', 'none');

    });

    /* id가 userName인 input tag 값 입력 시 발생되는 이벤트 */
    $('#userName').on("keypress", function () {

        $('#nameMsg').css('display', 'none');

    });

    /* DB에 가입할려는 아이디가 있는지 확인하는 함수
       비동기 ajax를 사용하여 값이 있으면 "1", 없으면 "0"이 반환 */
    function ajaxuserid(value) {

        $.ajax({
            url: "/regcheck",
            type: "post",
            dataType: 'text',
            data: {userid: value},
            timeout: 10000,
            success: function (res) {

                userIdCheck(value, res);

            }
        });
    }

    /* 아이디 체크 함수 */
    function userIdCheck(value, res) {

        var patt = /^(?=.*[a-z])(?=.*\d)[a-z\d]{5,15}$/;

        if (res == "1") {

            $('#idMsg').children('span').css('color', 'red');
            $('#idMsg').css('display', 'block');
            $('#idMsg').children('span').text("이미 사용중인 아이디입니다.")

        } else if (!patt.test(value)) {

            $('#idMsg').children('span').css('color', 'red');
            $('#idMsg').css('display', 'block');
            $('#idMsg').children('span').text("5~15자 영문 소문자 및 숫자만 사용 가능합니다.")

        } else if (res == "0") {

            $('#idMsg').children('span').css('color', 'blue');
            $('#idMsg').css('display', 'block');
            $('#idMsg').children('span').text("멋진 아이디네요!")

            useridcheck = true;

        }
    }

    /* 패스워드 체크 함수 */
    function userPwCheck(value, id) {

        var patt = /^[a-z0-9+]{4,8}$/;
        var pw1 = $('#userPw1').val();

        if (id == "userPw1") {
            if (!patt.test(value)) {

                $('#pwMsg1').children('span').css('color', 'red');
                $('#pwMsg1').css('display', 'block');
                $('#pwMsg1').children('span').text("4~8자 소문자, 숫자를 사용하세요.")

            } else {
                $('#pwMsg1').css('display', 'none');
                userpwcheck1 = true;
            }

        } else if (id == "userPw2") {

            if (pw1 != value) {

                $('#pwMsg2').children('span').css('color', 'red');
                $('#pwMsg2').css('display', 'block');
                $('#pwMsg2').children('span').text("비밀번호가 일치하지 않습니다.");

            } else {
                $('#pwMsg2').css('display', 'none');

                userpwcheck2 = true;
            }
        }
    }

    /* 이름 체크 함수 */
    function userNameCheck(value) {

        if (value == "") {

            $('#nameMsg').children('span').css('color', 'red');
            $('#nameMsg').css('display', 'block');
            $('#nameMsg').children('span').text("이름을 입력하세요.")

        } else {
            usernamecheck = true;
        }
    }

    /* 전화번호 체크 함수 */
    function userHpCheck(value) {

        var patt = /^\d{3}\d{3,4}\d{4}$/;

        if (!patt.test(value)) {

            $('#hpMsg').children('span').css('color', 'red');
            $('#hpMsg').css('display', 'block');
            $('#hpMsg').children('span').text("전화번호 입력이 잘못 되었습니다.")

        } else {
            $('#hpMsg').css('display', 'none');

            userhpcheck = true;
        }
    }
});