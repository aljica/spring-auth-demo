(this["webpackJsonpfrontend-auth"]=this["webpackJsonpfrontend-auth"]||[]).push([[0],{23:function(t,n,e){},24:function(t,n,e){},32:function(t,n,e){"use strict";e.r(n);var c=e(0),o=e.n(c),s=e(15),r=e.n(s),u=(e(23),e(24),e(17)),a=e(1),i=e(11),l=e.n(i),h=e(16),d=e(3),f=function(t){var n=window.location.host;function e(){return(e=Object(h.a)(l.a.mark((function t(){var e,c;return l.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,fetch(n+"/api/v1/student/getStudents");case 3:return 200!=(e=t.sent).status&&console.log("response not 200 ok"),t.next=7,e.json();case 7:c=t.sent,console.log(c),t.next=14;break;case 11:t.prev=11,t.t0=t.catch(0),console.log("failed");case 14:case"end":return t.stop()}}),t,null,[[0,11]])})))).apply(this,arguments)}return Object(d.jsxs)("div",{children:["Hello World From WelcomeScreen",Object(d.jsx)("button",{onClick:function(){return e.apply(this,arguments)},children:"click me"}),Object(d.jsx)("br",{}),Object(d.jsx)("button",{onClick:function(){try{fetch(n+"/logout")}catch(t){console.log("logout unsuccessful")}},children:"Logout"})]})};var j=function(){return Object(d.jsxs)(u.a,{children:[Object(d.jsx)("div",{className:"App"}),Object(d.jsx)(a.a,{path:"/",exact:!0,component:f})]})},p=function(t){t&&t instanceof Function&&e.e(3).then(e.bind(null,33)).then((function(n){var e=n.getCLS,c=n.getFID,o=n.getFCP,s=n.getLCP,r=n.getTTFB;e(t),c(t),o(t),s(t),r(t)}))};r.a.render(Object(d.jsx)(o.a.StrictMode,{children:Object(d.jsx)(j,{})}),document.getElementById("root")),p()}},[[32,1,2]]]);
//# sourceMappingURL=main.24a27cc0.chunk.js.map