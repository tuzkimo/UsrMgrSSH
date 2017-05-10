/**
 * Created by tuzkimo on 2017-05-02.
 */

$(document).ready(function () {
    /*
     * 失去焦点后验证
     */
    $('form :input, textarea').blur(function () {
        var $parent = $(this).parent();
        $parent.find('.formtips').remove();
        /*
         * 验证用户名
         */
        if ($(this).is('form :input[type=text]')) {
            var regexp = /^[\w\u4e00-\u9fa5\s]+$/;
            var length = this.value.length;
            var flag = true;

            if ($(this).val() == null || $(this).val() == "") {
                flag = false;
                var errorMsg = '名称不能为空';
                $parent.append($('<span class="formtips error">' + errorMsg + '</span>'));
            } else if (!regexp.test($(this).val())) {
                flag = false;
                var errorMsg = '名称不能包含非中英文字符';
                $parent.append($('<span class="formtips error">' + errorMsg + '</span>'));
            }

            if (length > 25) {
                flag = false;
                var errorMsg = '名称不能大于 25 个字符';
                $parent.append($('<span class="formtips error">' + errorMsg + '</span>'));
            }

            if (flag) {
                var okMsg = 'OK';
                $parent.append($('<span class="formtips ok">' + okMsg + '</span>'));
            }

            $.ajax({
                type:"GET",
                url:"checkName",
                dataType:"html",
                data:"name=" + $(this).val(),
                success:function (resultCode) {
                    if (resultCode == "0") {
                        $parent.find('.formtips').remove();
                        errorMsg = "用户已存在";
                        $parent.append($('<span class="formtips error">' + errorMsg + '</span>'));
                    }
                }
            })

        }
        /*
         * 验证密码
         */
        if ($(this).is('form :input[type=password]')) {
            var length = this.value.length;
            if (length >= 6 && length <= 20) {
                var okMsg = 'OK';
                $parent.append($('<span class="formtips ok">' + okMsg + '</span>'));
            } else {
                var errorMsg = '密码至少 6 位，最大 20 位';
                $parent.append($('<span class="formtips error">' + errorMsg + '</span>'));
            }
        }
        /*
         * 验证描述
         */
        if ($(this).is('form textarea')) {
            var regexp = /^[^<>#&]*$/;
            if (regexp.test($(this).val())) {
                var okMsg = 'OK';
                $parent.append($('<span class="formtips ok">' + okMsg + '</span>'));
            } else {
                var errorMsg = '不能包含 < > # & 等非法字符';
                $parent.append($('<span class="formtips error">' + errorMsg + '</span>'));
            }
        }
    }).keyup(function () {
        $(this).triggerHandler('blur');
    }).onfocus(function () {
        $(this).triggerHandler('blur');
    })
    /*
     * 验证提交
     */
    $('form').submit(function () {
        $('form :input, textarea').trigger('blur');
        if ($('form .error').length > 0) {
            return false;
        }
    })
})