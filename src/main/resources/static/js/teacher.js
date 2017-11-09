/**
 * Created by issuser on 2017/9/7.
 */
jQuery(function(){
    jQuery.ajax({
        type:"post",
        url:"/teacher/list",
        dataType:"json",
        success:function(data){
            var list=data.list;
            if(data != null){
                var op= jQuery("#teach_opt");
                var label=document.createElement("label");
                label.setAttribute("class","left")

                for(var i=0; i<list.length; i++) {
                        var input=document.createElement("input");
                        var a=document.createElement("a");
                        var span=document.createElement("span");
                        a.href="/teacher/get?id="+list[i].id;
                        input.setAttribute("type","radio");
                        input.setAttribute("class","radio_input");
                        input.setAttribute("id",list[i].id);
                        input.setAttribute("name","teacherId");
                        input.setAttribute("value",list[i].id);
                        span.innerHTML=list[i].teacherName;
                        a.appendChild(input);
                        a.appendChild(span);
                        label.appendChild(a);
                    }
                op.append(label)
            }
        }
    })

})
