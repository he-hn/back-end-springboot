"use strict";(self["webpackChunkfront_end_vue"]=self["webpackChunkfront_end_vue"]||[]).push([[759],{6007:function(n,a,r){r.r(a),r.d(a,{default:function(){return j}});var t=r(3396),e=r(4870),l=r(7139);const d={class:"card"},o=(0,t._)("div",{class:"card-header"}," ChildA ",-1),p={class:"card-body"},u=(0,t._)("hr",null,null,-1);var c={props:["prop1","prop2","productNo","productKind","productPrice"],setup(n){const a=n;return console.log("prop1: "+a.prop1),(a,r)=>((0,t.wg)(),(0,t.iD)("div",d,[o,(0,t._)("div",p,[(0,t._)("div",null,[(0,t._)("p",null,"prop1: "+(0,l.zw)(a.$attrs.prop1),1),(0,t._)("p",null,"prop2: "+(0,l.zw)(a.$attrs.prop2),1),(0,t._)("p",null,"productNo: "+(0,l.zw)(a.$attrs.productNo),1),(0,t._)("p",null,"productKind: "+(0,l.zw)(a.$attrs["product-kind"]),1),(0,t._)("p",null,"productPrice: "+(0,l.zw)(a.$attrs.productPrice),1)]),u,(0,t._)("div",null,[(0,t._)("p",null,"prop1: "+(0,l.zw)(n.prop1),1),(0,t._)("p",null,"prop2: "+(0,l.zw)(n.prop2),1),(0,t._)("p",null,"productNo: "+(0,l.zw)(n.productNo),1),(0,t._)("p",null,"productKind: "+(0,l.zw)(n.productKind),1),(0,t._)("p",null,"productPrice: "+(0,l.zw)(n.productPrice),1)])])]))}};const s=c;var i=s;const v={class:"card"},_=(0,t._)("div",{class:"card-header"}," ChildB ",-1),m={class:"card-body"};var w={props:["no","kind"],setup(n){return(a,r)=>((0,t.wg)(),(0,t.iD)("div",v,[_,(0,t._)("div",m,[(0,t._)("p",null,"no: "+(0,l.zw)(n.no),1),(0,t._)("p",null,"kind: "+(0,l.zw)(n.kind),1)])]))}};const b=w;var h=b;const f={class:"card"},z=(0,t._)("div",{class:"card-header"}," ChildC ",-1),g={class:"card-body"};var k={props:["product"],setup(n){return(a,r)=>((0,t.wg)(),(0,t.iD)("div",f,[z,(0,t._)("div",g,[(0,t._)("p",null,"no: "+(0,l.zw)(n.product.no),1),(0,t._)("p",null,"kind: "+(0,l.zw)(n.product.kind),1)])]))}};const C=k;var y=C;const D={class:"card"},S=(0,t._)("div",{class:"card-header"}," ChildD ",-1),U={class:"card-body"},E=(0,t.Uk)(" propG: ");var H={props:{propA:String,propB:Number,propC:[String,Number],propD:{type:String,required:!0},propE:{type:Number,default:5},propF:{type:Object,default(){return{message:"Hello"}}},propG:{type:Array,default(){return["black","white"]}},propH:{type:Function,default(){return"default value"}},propI:{type:Number,validator(n){return n>0}}},setup(n){return(a,r)=>((0,t.wg)(),(0,t.iD)("div",D,[S,(0,t._)("div",U,[(0,t._)("p",null,"propA: "+(0,l.zw)(n.propA),1),(0,t._)("p",null,"propB: "+(0,l.zw)(n.propB),1),(0,t._)("p",null,"propC: "+(0,l.zw)(n.propC),1),(0,t._)("p",null,"propD: "+(0,l.zw)(n.propD),1),(0,t._)("p",null,"propE: "+(0,l.zw)(n.propE),1),(0,t._)("p",null,"propF: "+(0,l.zw)(n.propF.message),1),(0,t._)("p",null,[E,(0,t._)("ul",null,[((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(n.propG,((n,a)=>((0,t.wg)(),(0,t.iD)("li",{key:a},(0,l.zw)(n),1)))),128))])]),(0,t._)("p",null,"propH: "+(0,l.zw)(n.propH()),1),(0,t._)("p",null,"propI: "+(0,l.zw)(n.propI),1)])]))}};const N=H;var W=N;const P={class:"card"},A=(0,t._)("div",{class:"card-header"}," Exam01Props ",-1),B={class:"card-body"},$=(0,t._)("hr",null,null,-1),F=(0,t._)("hr",null,null,-1);var I={setup(n){const a=(0,e.qj)({no:1,kind:"bag"});function r(){a.no++,a.kind+=" bag"}return(n,d)=>((0,t.wg)(),(0,t.iD)("div",P,[A,(0,t._)("div",B,[(0,t.Wm)(i,{prop1:"value1",prop2:"value2",productNo:"1","product-kind":"bag",productPrice:1e3}),$,(0,t.Wm)(h,{no:(0,e.SU)(a).no,kind:(0,e.SU)(a).kind},null,8,["no","kind"]),(0,t.Wm)(h,(0,l.vs)((0,t.F4)((0,e.SU)(a))),null,16),(0,t.Wm)(y,{product:(0,e.SU)(a)},null,8,["product"]),(0,t._)("button",{onClick:r,class:"btn btn-info btn-sm mt-2"},"부모 데이터 변경"),F,(0,t.Wm)(W,{propA:"문자열",propB:1,"prop-c":2,"prop-d":"value","prop-f":{message:"안녕하세요"},"prop-g":["red","green","blue"],"prop-h":()=>"prop value","prop-i":4},null,8,["prop-h"])])]))}};const K=I;var j=K},3910:function(n,a,r){r.r(a),r.d(a,{default:function(){return g}});var t=r(3396),e=r(7139),l=r(4870);const d={class:"card"},o=(0,t._)("div",{class:"card-header"}," Child ",-1),p={class:"card-body"},u=(0,t._)("h6",null,"[자식 -> 부모]",-1),c=(0,t._)("hr",null,null,-1),s=(0,t._)("h6",null,"[자식 (event)-> 부모 (props)-> 자식]",-1),i=(0,t._)("hr",null,null,-1);var v={props:["counter"],emits:["child-event-2","increment-event","decrement-event"],setup(n,{emit:a}){const r=(0,l.iH)("value1"),v=(0,l.iH)(100);function _(){a("child-event-2",r.value,v.value)}function m(){a("increment-event")}function w(){a("decrement-event")}return(a,l)=>((0,t.wg)(),(0,t.iD)("div",d,[o,(0,t._)("div",p,[(0,t._)("div",null,[u,(0,t._)("button",{onClick:l[0]||(l[0]=n=>a.$emit("child-event-1",r.value)),class:"btn btn-info btn-sm mr-2"},"child-event-1 emit"),(0,t._)("button",{onClick:_,class:"btn btn-info btn-sm mr-2"},"child-event-2 emit")]),c,(0,t._)("div",null,[s,(0,t._)("button",{onClick:m,class:"btn btn-info btn-sm mr-2"},"increment-event emit"),(0,t._)("button",{onClick:w,class:"btn btn-info btn-sm mr-2"},"decrement-event emit"),(0,t._)("p",null,"Counter: "+(0,e.zw)(n.counter),1)]),i])]))}};const _=v;var m=_;const w={class:"card"},b=(0,t._)("div",{class:"card-header"}," Exam02EventEmit ",-1),h={class:"card-body"};var f={setup(n){const a=(0,l.iH)(0);function r(n){console.log("data1:",n)}function e(n,a){console.log("data1: ",n),console.log("data2: ",a)}function d(){a.value--}return(n,l)=>((0,t.wg)(),(0,t.iD)("div",w,[b,(0,t._)("div",h,[(0,t.Wm)(m,{onChildEvent1:r,onChildEvent2:e,counter:a.value,onIncrementEvent:l[0]||(l[0]=n=>a.value++),onDecrementEvent:d},null,8,["counter"])])]))}};const z=f;var g=z},4957:function(n,a,r){r.r(a),r.d(a,{default:function(){return H}});var t=r(3396),e=r(4870),l=r(7139);const d={class:"card"},o=(0,t._)("div",{class:"card-header"}," ChildA ",-1),p={class:"card-body"};var u={setup(n){const a=(0,t.f3)("message");function r(){a.data1.value+="1",a.data2.value.name1+="2",a.data2.value.name2+="3",a.data3.name3+="4",a.data3.name4+="5"}return(n,u)=>((0,t.wg)(),(0,t.iD)("div",d,[o,(0,t._)("div",p,[(0,t._)("p",null,"data1:1 "+(0,l.zw)((0,e.SU)(a).data1),1),(0,t._)("p",null,"data2.value.name1: "+(0,l.zw)((0,e.SU)(a).data2.value.name1),1),(0,t._)("p",null,"data2.value.name2: "+(0,l.zw)((0,e.SU)(a).data2.value.name2),1),(0,t._)("p",null,"data3.name3: "+(0,l.zw)((0,e.SU)(a).data3.name3),1),(0,t._)("p",null,"data3.value.name1: "+(0,l.zw)((0,e.SU)(a).data3.name2),1),(0,t._)("button",{onClick:r,class:"mt-2 btn btn-info btn-sm"},"데이터 변경")])]))}};const c=u;var s=c;const i={class:"card"},v=(0,t._)("div",{class:"card-header"}," ChildC ",-1),_={class:"card-body"};var m={setup(n){const a=(0,t.f3)("message");return(n,r)=>((0,t.wg)(),(0,t.iD)("div",i,[v,(0,t._)("div",_,[(0,t._)("p",null,"data1:1 "+(0,l.zw)((0,e.SU)(a).data1),1),(0,t._)("p",null,"data2.value.name1: "+(0,l.zw)((0,e.SU)(a).data2.value.name1),1),(0,t._)("p",null,"data2.value.name2: "+(0,l.zw)((0,e.SU)(a).data2.value.name2),1),(0,t._)("p",null,"data3.name3: "+(0,l.zw)((0,e.SU)(a).data3.name3),1),(0,t._)("p",null,"data3.value.name1: "+(0,l.zw)((0,e.SU)(a).data3.name2),1)])]))}};const w=m;var b=w;const h={class:"card"},f=(0,t._)("div",{class:"card-header"}," ChildB ",-1),z={class:"card-body"};var g={setup(n){return(n,a)=>((0,t.wg)(),(0,t.iD)("div",h,[f,(0,t._)("div",z,[(0,t.Wm)(b)])]))}};const k=g;var C=k;const y={class:"card"},D=(0,t._)("div",{class:"card-header"}," Exam03ProvideInject ",-1),S={class:"card-body"};var U={setup(n){const a=(0,e.iH)("parent-value1"),r=(0,e.iH)({name1:"parent-value2",name2:"parent-value3"}),l=(0,e.qj)({name3:"parent-value3",name4:"prevent-value4"});return(0,t.JJ)("message",{data1:a,data2:r,data3:l}),(n,a)=>((0,t.wg)(),(0,t.iD)("div",y,[D,(0,t._)("div",S,[(0,t.Wm)(s,{class:"mb-2"}),(0,t.Wm)((0,e.SU)(C))])]))}};const E=U;var H=E}}]);
//# sourceMappingURL=menu04.e87394b6.js.map