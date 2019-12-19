const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => container.classList.add('right-panel-active'));

signInButton.addEventListener('click', () => container.classList.remove('right-panel-active'));

/*
@author https://github.com/macek/jquery-serialize-object
*/
$.fn.serializeObject = function () {
    var result = {}
    var extend = function (i, element) {
        var node = result[element.name]
        if ("undefined" !== typeof node && node !== null) {
            if ($.isArray(node)) {
                node.push(element.value)
            } else {
                result[element.name] = [node, element.value]
            }
        } else {
            result[element.name] = element.value
        }
    }
    $.each(this.serializeArray(), extend)
    return result
} 


function test(url, params, type, callback) {
    $.ajax({
        url: url,
        type: type,
        contentType: 'application/json; charset=UTF-8',
        dataType: 'text',
        data: params,
        timeout: 10000,
        success: function (res) {
            callback(res);
        }
    });
};

$(document).ready(function () {

    $("form[name=signup_form]").submit(function (e) {

        e.preventDefault();

        var data = $(this).serializeObject();

        test("/signup", JSON.stringify(data), "post", function (res) {
            if (res == 'success') {
                location.href = "/home";
            }
        });

    });

});