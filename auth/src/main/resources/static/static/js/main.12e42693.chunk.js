(this["webpackJsonpfrontend-auth"]=this["webpackJsonpfrontend-auth"]||[]).push([[0],{24:function(e,t,n){},25:function(e,t,n){},33:function(e,t,n){"use strict";n.r(t);var c=n(0),r=n.n(c),o=n(16),s=n.n(o),a=(n(24),n(25),n(17)),u=n(1),i=n(9),l=n.n(i),h=n(12),j=n(19),p=n(3),f=function(e){var t=Object(c.useState)(null),n=Object(j.a)(t,2),r=n[0],o=n[1],s=window.location.host,a="http://localhost:8080";function u(){return(u=Object(h.a)(l.a.mark((function e(){var t,n;return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,fetch(a+"/api/v1/student/getStudents");case 3:return 200!==(t=e.sent).status&&console.log("response not 200 ok"),e.next=7,t.json();case 7:n=e.sent,console.log(n),e.next=14;break;case 11:e.prev=11,e.t0=e.catch(0),console.log("failed");case 14:case"end":return e.stop()}}),e,null,[[0,11]])})))).apply(this,arguments)}function i(){return(i=Object(h.a)(l.a.mark((function e(){var t,n;return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,fetch(a+"/api/v1/user/getUsers");case 3:return t=e.sent,e.next=6,t.json();case 6:n=e.sent,o(n),e.next=13;break;case 10:e.prev=10,e.t0=e.catch(0),console.log("failed to fetch registered users");case 13:case"end":return e.stop()}}),e,null,[[0,10]])})))).apply(this,arguments)}return Object(p.jsxs)("div",{children:["Hello World From WelcomeScreen",Object(p.jsx)("button",{onClick:function(){return u.apply(this,arguments)},children:"click me"}),Object(p.jsx)("br",{}),Object(p.jsx)("button",{onClick:function(){try{fetch(s+"/logout")}catch(e){console.log("logout unsuccessful")}},children:"Logout"}),Object(p.jsx)("br",{}),Object(p.jsx)("h1",{children:null===r?"Load Users Below":Object(p.jsx)("h1",{children:r.map((function(e){return e+", "}))})}),Object(p.jsx)("button",{onClick:function(){return i.apply(this,arguments)},children:"Load Users"})]})};var d=function(){return Object(p.jsxs)(a.a,{children:[Object(p.jsx)("div",{className:"App"}),Object(p.jsx)(u.a,{path:"/",exact:!0,component:f})]})},b=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,34)).then((function(t){var n=t.getCLS,c=t.getFID,r=t.getFCP,o=t.getLCP,s=t.getTTFB;n(e),c(e),r(e),o(e),s(e)}))};s.a.render(Object(p.jsx)(r.a.StrictMode,{children:Object(p.jsx)(d,{})}),document.getElementById("root")),b()}},[[33,1,2]]]);
//# sourceMappingURL=main.12e42693.chunk.js.map