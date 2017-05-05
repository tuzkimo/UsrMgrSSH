/**
 * Created by tuzkimo on 2017-05-02.
 */

$(document).ready(function () {
    /*
     * 失去焦点后验证
     */
    $('form :input, form textarea').blur(function () {
        var $parent = $(this).parent();
        $parent.find('.formtips').remove();
        /*
         * 验证用户名
         */
        if ($(this).is('form :input[type=text]')) {
            var regexp = /^[\w\u4e00-\u9fa5]+$/;
            var length = this.value.length;
            if (regexp.test($(this).val())) {
                if (length != "" && length <= 25) {
                    var okMsg = 'OK';
                    $parent.append($('<span class="formtips ok">' + okMsg + '</span>'));
                } else {
                    var errorMsg1 = '名称不能为空并不能大于 25 位';
                    $parent.append($('<span class="formtips error">' + errorMsg1 + '</span>'));
                }
            } else {
                var errorMsg2 = '名称只能包含中英文字符和数字';
                $parent.append($('<span class="formtips error">' + errorMsg2 + '</span>'));
            }
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
    })
    /*
     * 验证提交
     */
    $('form').submit(function () {
        $('form :input').trigger('blur');
        if ($('form .error').length > 0) {
            return false;
        }
    })
})