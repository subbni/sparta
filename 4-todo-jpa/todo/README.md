# CH 3 일정 관리 앱 과제
## 🗒️ 프로젝트 정보
### 개발 기간
`2025.02.06` ~ `2025.02.13`
### 개발 인원
1인 (개인)
### 설명
SpringBoot와 JPA를 사용하여 기본적인 CRUD API를 구현합니다.

### 사용 기술
![](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white")
![](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white)
![](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
![](https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white")

### 파일 구조
```
todo/src/main/java/com/example/todo
├── TodoApplication.java
├── auth
│   ├── controller
│   │   └── AuthController.java
│   ├── dto
│   │   └── LoginUserRequest.java
│   └── service
│       └── AuthService.java
├── comment
│   ├── controller
│   │   └── CommentController.java
│   ├── domain
│   │   └── Comment.java
│   ├── dto
│   │   ├── CommentResponse.java
│   │   ├── CreateCommentRequest.java
│   │   └── UpdateCommentRequest.java
│   ├── repository
│   │   └── CommentRepository.java
│   └── service
│       ├── CommentFacadeService.java
│       └── CommentService.java
├── config
│   ├── WebConfig.java
│   ├── filter
│   │   └── LoginCheckFilter.java
│   ├── resolver
│   │   └── CurrentUserIdArgumentResolver.java
│   └── security
│       └── PasswordEncoder.java
├── exception
│   ├── CustomException.java
│   ├── ErrorResponse.java
│   ├── ExceptionType.java
│   └── GlobalExceptionHandler.java
├── global
│   ├── BaseTimeEntity.java
│   └── annotation
│       └── CurrentUserId.java
├── todo
│   ├── controller
│   │   └── TodoController.java
│   ├── domain
│   │   └── Todo.java
│   ├── dto
│   │   ├── CreateTodoRequest.java
│   │   ├── TodoResponse.java
│   │   └── UpdateTodoRequest.java
│   ├── repository
│   │   └── TodoRepository.java
│   └── service
│       ├── TodoFacadeService.java
│       └── TodoService.java
└── user
    ├── controller
    │   └── UserController.java
    ├── domain
    │   ├── AccountStatus.java
    │   └── User.java
    ├── dto
    │   ├── CreateUserRequest.java
    │   ├── CreateUserResponse.java
    │   ├── UpdateUserRequest.java
    │   └── UserProfile.java
    ├── repository
    │   └── UserRepository.java
    └── service
        ├── UserFacadeService.java
        └── UserService.java
```
---

## API 명세
### Notion에서 보기 : [Link](https://www.notion.so/API-199a2f5349be80b78517fce8690d5c83?pvs=4)

<table class="collection-content">
            <thead>
              <tr>
                <th>
                  <span class="icon property-icon"
                    ><svg
                      aria-hidden="true"
                      role="graphics-symbol"
                      viewBox="0 0 16 16"
                      style="
                        width: 14px;
                        height: 14px;
                        display: block;
                        fill: rgba(55, 53, 47, 0.45);
                        flex-shrink: 0;
                      "
                      class="typesTitle"
                    >
                      <path
                        d="M0.637695 13.1914C1.0957 13.1914 1.32812 13 1.47852 12.5215L2.24414 10.3887H6.14746L6.90625 12.5215C7.05664 13 7.2959 13.1914 7.74707 13.1914C8.22559 13.1914 8.5332 12.9043 8.5332 12.4531C8.5332 12.2891 8.50586 12.1523 8.44434 11.9678L5.41602 3.79199C5.2041 3.21777 4.82129 2.9375 4.19922 2.9375C3.60449 2.9375 3.21484 3.21777 3.0166 3.78516L-0.0322266 12.002C-0.09375 12.1797 -0.121094 12.3232 -0.121094 12.4668C-0.121094 12.918 0.166016 13.1914 0.637695 13.1914ZM2.63379 9.12402L4.17871 4.68066H4.21973L5.76465 9.12402H2.63379ZM12.2793 13.2324C13.3115 13.2324 14.2891 12.6787 14.7129 11.8037H14.7402V12.5762C14.7471 12.9863 15.0273 13.2393 15.4238 13.2393C15.834 13.2393 16.1143 12.9795 16.1143 12.5215V8.00977C16.1143 6.49902 14.9658 5.52148 13.1543 5.52148C11.7666 5.52148 10.6592 6.08887 10.2695 6.99121C10.1943 7.15527 10.1533 7.3125 10.1533 7.46289C10.1533 7.81152 10.4062 8.04395 10.7686 8.04395C11.0215 8.04395 11.2129 7.94824 11.3496 7.73633C11.7529 6.99121 12.2861 6.65625 13.1064 6.65625C14.0977 6.65625 14.6992 7.20996 14.6992 8.1123V8.67285L12.5664 8.7959C10.7686 8.8916 9.77734 9.69824 9.77734 11.0107C9.77734 12.3369 10.8096 13.2324 12.2793 13.2324ZM12.6621 12.1387C11.8008 12.1387 11.2129 11.667 11.2129 10.9561C11.2129 10.2725 11.7598 9.82129 12.7578 9.75977L14.6992 9.62988V10.3203C14.6992 11.3457 13.7969 12.1387 12.6621 12.1387Z"
                      ></path></svg></span
                  >기능
                </th>
                <th>
                  <span class="icon property-icon"
                    ><svg
                      aria-hidden="true"
                      role="graphics-symbol"
                      viewBox="0 0 16 16"
                      style="
                        width: 14px;
                        height: 14px;
                        display: block;
                        fill: rgba(55, 53, 47, 0.45);
                        flex-shrink: 0;
                      "
                      class="typesSelect"
                    >
                      <path
                        d="M8 15.126C11.8623 15.126 15.0615 11.9336 15.0615 8.06445C15.0615 4.20215 11.8623 1.00293 7.99316 1.00293C4.13086 1.00293 0.938477 4.20215 0.938477 8.06445C0.938477 11.9336 4.1377 15.126 8 15.126ZM8 13.7383C4.85547 13.7383 2.33301 11.209 2.33301 8.06445C2.33301 4.91992 4.84863 2.39746 7.99316 2.39746C11.1377 2.39746 13.6738 4.91992 13.6738 8.06445C13.6738 11.209 11.1445 13.7383 8 13.7383ZM7.62402 10.6348C7.79492 10.915 8.20508 10.9287 8.37598 10.6348L10.666 6.73145C10.8574 6.41016 10.7002 6.04102 10.3652 6.04102H5.62793C5.29297 6.04102 5.14941 6.43066 5.32031 6.73145L7.62402 10.6348Z"
                      ></path></svg></span
                  >Method
                </th>
                <th>
                  <span class="icon property-icon"
                    ><svg
                      aria-hidden="true"
                      role="graphics-symbol"
                      viewBox="0 0 16 16"
                      style="
                        width: 14px;
                        height: 14px;
                        display: block;
                        fill: rgba(55, 53, 47, 0.45);
                        flex-shrink: 0;
                      "
                      class="typesText"
                    >
                      <path
                        d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"
                      ></path></svg></span
                  >URI
                </th>
                <th>
                  <span class="icon property-icon"
                    ><svg
                      aria-hidden="true"
                      role="graphics-symbol"
                      viewBox="0 0 16 16"
                      style="
                        width: 14px;
                        height: 14px;
                        display: block;
                        fill: rgba(55, 53, 47, 0.45);
                        flex-shrink: 0;
                      "
                      class="typesText"
                    >
                      <path
                        d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"
                      ></path></svg></span
                  >request
                </th>
                <th>
                  <span class="icon property-icon"
                    ><svg
                      aria-hidden="true"
                      role="graphics-symbol"
                      viewBox="0 0 16 16"
                      style="
                        width: 14px;
                        height: 14px;
                        display: block;
                        fill: rgba(55, 53, 47, 0.45);
                        flex-shrink: 0;
                      "
                      class="typesText"
                    >
                      <path
                        d="M1.56738 3.25879H14.4258C14.7676 3.25879 15.0479 2.97852 15.0479 2.63672C15.0479 2.29492 14.7744 2.02148 14.4258 2.02148H1.56738C1.21875 2.02148 0.952148 2.29492 0.952148 2.63672C0.952148 2.97852 1.22559 3.25879 1.56738 3.25879ZM1.56738 6.84082H14.4258C14.7676 6.84082 15.0479 6.56055 15.0479 6.21875C15.0479 5.87695 14.7744 5.60352 14.4258 5.60352H1.56738C1.21875 5.60352 0.952148 5.87695 0.952148 6.21875C0.952148 6.56055 1.22559 6.84082 1.56738 6.84082ZM1.56738 10.4229H14.4258C14.7676 10.4229 15.0479 10.1426 15.0479 9.80078C15.0479 9.45898 14.7744 9.18555 14.4258 9.18555H1.56738C1.21875 9.18555 0.952148 9.45898 0.952148 9.80078C0.952148 10.1426 1.22559 10.4229 1.56738 10.4229ZM1.56738 14.0049H8.75879C9.10059 14.0049 9.38086 13.7246 9.38086 13.3828C9.38086 13.041 9.10742 12.7676 8.75879 12.7676H1.56738C1.21875 12.7676 0.952148 13.041 0.952148 13.3828C0.952148 13.7246 1.22559 14.0049 1.56738 14.0049Z"
                      ></path></svg></span
                  >response
                </th>
                <th>
                  <span class="icon property-icon"
                    ><svg
                      aria-hidden="true"
                      role="graphics-symbol"
                      viewBox="0 0 16 16"
                      style="
                        width: 14px;
                        height: 14px;
                        display: block;
                        fill: rgba(55, 53, 47, 0.45);
                        flex-shrink: 0;
                      "
                      class="typesSelect"
                    >
                      <path
                        d="M8 15.126C11.8623 15.126 15.0615 11.9336 15.0615 8.06445C15.0615 4.20215 11.8623 1.00293 7.99316 1.00293C4.13086 1.00293 0.938477 4.20215 0.938477 8.06445C0.938477 11.9336 4.1377 15.126 8 15.126ZM8 13.7383C4.85547 13.7383 2.33301 11.209 2.33301 8.06445C2.33301 4.91992 4.84863 2.39746 7.99316 2.39746C11.1377 2.39746 13.6738 4.91992 13.6738 8.06445C13.6738 11.209 11.1445 13.7383 8 13.7383ZM7.62402 10.6348C7.79492 10.915 8.20508 10.9287 8.37598 10.6348L10.666 6.73145C10.8574 6.41016 10.7002 6.04102 10.3652 6.04102H5.62793C5.29297 6.04102 5.14941 6.43066 5.32031 6.73145L7.62402 10.6348Z"
                      ></path></svg></span
                  >상태코드
                </th>
              </tr>
            </thead>
            <tbody>
              <tr id="199a2f53-49be-8000-a3e2-c20b1c96eab3">
                <td class="cell-title"><a>회원가입</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-yellow"
                    >POST</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/users</code>/register</td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;name&quot;<em>:</em> &quot;테스트3&quot;<em
                    >,</em
                  >
                  <br />&quot;email&quot;<br /><em>:</em>
                  &quot;test3@gmail.com&quot;<em>,</em> &quot;password&quot;<em
                    >:</em
                  >
                  &quot;password&quot;<em>}</em>
                </td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 3<em>,</em>
                  <br />&quot;name&quot;<br /><em>:</em> &quot;테스트3&quot;<em
                    >,</em
                  >
                  <br />&quot;email&quot;<br /><em>:</em>
                  &quot;test3@gmail.com&quot;<em>}</em>
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-yellow"
                    >201</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80d0-8d3e-c5194b4c9161">
                <td class="cell-title"><a>회원 조회</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-blue"
                    >GET</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/users</code> /{userId}</td>
                <td class="cell-&lt;O;_"></td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 1<em>,</em>
                  &quot;name&quot;<em>:</em> &quot;테스트 사용자&quot;<em>,</em>
                  &quot;email&quot;<em>:</em> &quot;test@gmail.com&quot;<em
                    >}</em
                  >
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-8052-8cc5-ee589be21173">
                <td class="cell-title"><a>회원 정보 수정</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-pink"
                    >PUT</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/users</code> /{userId}</td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;name&quot;<em>:</em> &quot;테스트 사용자
                  수정&quot;<em>,</em> &quot;password&quot;<em>:</em>
                  &quot;password&quot;<em>}</em>
                </td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 1<em>,</em>
                  &quot;name&quot;<em>:</em> &quot;테스트 사용자 수정&quot;<em
                    >,</em
                  >
                  &quot;email&quot;<em>:</em> &quot;test@gmail.com&quot;<em
                    >}</em
                  >
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80d4-b893-fa1d0a271564">
                <td class="cell-title"><a>회원탈퇴</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-gray"
                    >DELETE</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/users</code> /{userId}</td>
                <td class="cell-&lt;O;_"></td>
                <td class="cell-\PJh"></td>
                <td class="cell-Mm?z"></td>
              </tr>
              <tr id="199a2f53-49be-80bc-b693-ee9d5c975351">
                <td class="cell-title"><a>로그인</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-yellow"
                    >POST</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/auth</code>/login</td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;email&quot;<em>:</em>
                  &quot;test@gmail.com&quot;<em>,</em> &quot;password&quot;<em
                    >:</em
                  >
                  &quot;password&quot;<em>}</em>
                </td>
                <td class="cell-\PJh"></td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80b9-9f93-e64ef5d7c876">
                <td class="cell-title"><a>로그아웃</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-yellow"
                    >POST</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/auth</code>/logout</td>
                <td class="cell-&lt;O;_"></td>
                <td class="cell-\PJh"></td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80ef-9876-c05d9e07f13e">
                <td class="cell-title"><a>일정 생성</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-yellow"
                    >POST</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/todos</code></td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;title&quot;<em>:</em> &quot;세탁소
                  가기&quot;<em>,</em> &quot;content&quot;<em>:</em> &quot;이불
                  빨래&quot;<em>}</em>
                </td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 5<em>,</em>
                  &quot;title&quot;<em>:</em> &quot;세탁소 가기&quot;<em>,</em>
                  &quot;content&quot;<em>:</em> &quot;이불 빨래&quot;<em>,</em>
                  &quot;createdAt&quot;<em>:</em>
                  &quot;2025-02-11T16:28:48.926593&quot;<em>,</em>
                  &quot;updatedAt&quot;<em>:</em>
                  &quot;2025-02-11T16:28:48.926593&quot;<em>,</em>
                  &quot;userId&quot;<em>:</em> 4<em>,</em>
                  &quot;userName&quot;<em>:</em> &quot;탈퇴 테스트 유저&quot;<em
                    >}</em
                  >
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-yellow"
                    >201</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-8097-b7e8-f83b6a3d0f82">
                <td class="cell-title"><a>일정 조회 (단일)</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-blue"
                    >GET</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/todos</code> /{todoId}</td>
                <td class="cell-&lt;O;_">ex) /api/todos/1</td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 1<em>,</em>
                  &quot;title&quot;<em>:</em> &quot;장보기&quot;<em>,</em>
                  &quot;content&quot;<em>:</em> &quot;바나나랑 사과&quot;<em
                    >,</em
                  >
                  &quot;createdAt&quot;<em>:</em>
                  &quot;2025-02-10T17:53:40&quot;<em>,</em>
                  &quot;updatedAt&quot;<em>:</em>
                  &quot;2025-02-10T17:55:13&quot;<em>,</em>
                  &quot;userId&quot;<em>:</em> 1<em>,</em>
                  &quot;userName&quot;<em>:</em> &quot;테스트 사용자&quot;<em
                    >,</em
                  >
                  &quot;cntOfComments&quot;<em>:</em> 1<em>}</em>
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80c9-918b-e9ff6751a694">
                <td class="cell-title"><a>일정 목록 조회 (전체)</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-blue"
                    >GET</span
                  >
                </td>
                <td class="cell-TYg\">
                  <code>/api/todos</code>
                  ?<br />size={size}<br />&amp;page={page}<br />
                </td>
                <td class="cell-&lt;O;_">ex) /api/todos?size=1&amp;page=0</td>
                <td class="cell-\PJh">
                  {&quot;content&quot;:[{&quot;id&quot;:4,&quot;title&quot;:&quot;빨래
                  하기&quot;,&quot;content&quot;:&quot;이불
                  빨래&quot;,&quot;createdAt&quot;:&quot;2025-02-10T21:03:34&quot;,&quot;updatedAt&quot;:&quot;2025-02-10T21:03:34&quot;,&quot;userId&quot;:3,&quot;userName&quot;:&quot;테스트3&quot;,&quot;cntOfComments&quot;:0}],&quot;pageable&quot;:{&quot;pageNumber&quot;:0,&quot;pageSize&quot;:1,&quot;sort&quot;:{&quot;empty&quot;:false,&quot;unsorted&quot;:false,&quot;sorted&quot;:true},&quot;offset&quot;:0,&quot;unpaged&quot;:false,&quot;paged&quot;:true},&quot;last&quot;:false,&quot;totalPages&quot;:2,&quot;totalElements&quot;:2,&quot;first&quot;:true,&quot;size&quot;:1,&quot;number&quot;:0,&quot;sort&quot;:{&quot;empty&quot;:false,&quot;unsorted&quot;:false,&quot;sorted&quot;:true},&quot;numberOfElements&quot;:1,&quot;empty&quot;:false}
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-8057-819d-e0671d7a4e6e">
                <td class="cell-title"><a>일정 수정</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-pink"
                    >PUT</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/todos</code> /{todoId}</td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;title&quot;<em>:</em> &quot;장보기
                  (수정됨)&quot;<em>,</em> &quot;content&quot;<em>:</em>
                  &quot;바나나랑 사과&quot;<em>}</em>
                </td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 1<em>,</em>
                  &quot;title&quot;<em>:</em> &quot;장보기 (수정됨)&quot;<em
                    >,</em
                  >
                  &quot;content&quot;<em>:</em> &quot;바나나랑 사과&quot;<em
                    >,</em
                  >
                  &quot;createdAt&quot;<em>:</em>
                  &quot;2025-02-10T17:53:40&quot;<em>,</em>
                  &quot;updatedAt&quot;<em>:</em>
                  &quot;2025-02-10T17:55:13&quot;<em>,</em>
                  &quot;userId&quot;<em>:</em> 1<em>,</em>
                  &quot;userName&quot;<em>:</em> &quot;테스트 사용자
                  수정&quot;<em>,</em> &quot;cntOfComments&quot;<em>:</em> 1<em
                    >}</em
                  >
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-8051-b977-f2b72930b300">
                <td class="cell-title"><a>일정 삭제</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-gray"
                    >DELETE</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/todos</code> /{todoId}</td>
                <td class="cell-&lt;O;_"></td>
                <td class="cell-\PJh"></td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80d8-9b4d-e505daadfc77">
                <td class="cell-title"><a>댓글 생성</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-yellow"
                    >POST</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/comments</code></td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;todoId&quot; <em>:</em> 1<em>,</em>
                  &quot;content&quot;<em>:</em> &quot;아무거나
                  적어볼게요&quot;<em>}</em>
                </td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 2<em>,</em>
                  &quot;content&quot;<em>:</em> &quot;아무거나
                  적어볼게요&quot;<em>,</em> &quot;userId&quot;<em>:</em> 1<em
                    >,</em
                  >
                  &quot;userName&quot;<em>:</em> &quot;테스트 사용자&quot;<em
                    >,</em
                  >
                  &quot;todoId&quot;<em>:</em> 1<em>}</em>
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-yellow"
                    >201</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80c5-a46d-e632da5d450a">
                <td class="cell-title"><a>댓글 조회 (단일)</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-blue"
                    >GET</span
                  >
                </td>
                <td class="cell-TYg\">
                  <code>/api/comments</code> /{commentId}
                </td>
                <td class="cell-&lt;O;_">ex) /api/comments/1</td>
                <td class="cell-\PJh">
                  &quot;id&quot;<em>:</em> 1<em>,</em> &quot;content&quot;<em
                    >:</em
                  >
                  &quot;하이&quot;<em>,</em> &quot;userId&quot;<em>:</em> 1<em
                    >,</em
                  >
                  &quot;userName&quot;<em>:</em> &quot;테스트 사용자&quot;<em
                    >,</em
                  >
                  &quot;todoId&quot;<em>:</em> 1<em>}</em>
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80aa-b286-d208813d8822">
                <td class="cell-title"><a>댓글 수정</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-pink"
                    >PUT</span
                  >
                </td>
                <td class="cell-TYg\">
                  <code>/api/comments</code> /commentId}
                </td>
                <td class="cell-&lt;O;_">
                  <em>{</em> &quot;content&quot;
                  <em>:</em> &quot;수정해볼게요&quot;<em>}</em>
                </td>
                <td class="cell-\PJh">
                  <em>{</em> &quot;id&quot;<em>:</em> 1<em>,</em>
                  &quot;content&quot;<em>:</em> &quot;수정해볼게요&quot;<em
                    >,</em
                  >
                  &quot;userId&quot;<em>:</em> 1<em>,</em>
                  &quot;userName&quot;<em>:</em> &quot;테스트 사용자&quot;<em
                    >,</em
                  >
                  &quot;todoId&quot;<em>:</em> 1<em>}</em>
                </td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
              <tr id="199a2f53-49be-80c3-b5e0-c7608fd9e35b">
                <td class="cell-title"><a>댓글 삭제</a></td>
                <td class="cell-oWjl">
                  <span class="selected-value select-value-color-gray"
                    >DELETE</span
                  >
                </td>
                <td class="cell-TYg\"><code>/api/comments</code></td>
                <td class="cell-&lt;O;_"></td>
                <td class="cell-\PJh"></td>
                <td class="cell-Mm?z">
                  <span class="selected-value select-value-color-purple"
                    >200</span
                  >
                </td>
              </tr>
            </tbody>
          </table>

## ERD
<img width="700" alt="Screenshot 2025-02-13 at 13 52 45" src="https://github.com/user-attachments/assets/565955fd-14d8-4eff-8298-1f01835b4076" />



## 🗒️ 구현 내용
> 자세한 구현 내용은 [Issue #22](https://github.com/subbni/sparta/issues/22)의 커밋들을 통해 확인할 수 있습니다.
### 유저 CRUD
- 회원가입
  - 비밀번호는 [`PasswordEncoder`](https://github.com/subbni/sparta/blob/main/4-todo-jpa/todo/src/main/java/com/example/todo/config/security/PasswordEncoder.java)로 암호화하여 저장합니다.
- 유저 프로필 조회
  - id로 조회합니다.
- 유저 정보 수정
  - 이름과 비밀번호를 수정합니다.
- 회원탈퇴
  - Soft Delete를 수행합니다.
  - 사용자가 작성한 일정과 댓글도 Soft Delete 처리 됩니다.
  - [관련 TIL](https://subbni.tistory.com/101)
### 로그인/로그아웃
- 로그인
  - 이메일과 비밀번호로 로그인합니다.
  - 세션 기반으로 로그인을 진행하며 [`LoginCheckFilter`](https://github.com/subbni/sparta/blob/main/4-todo-jpa/todo/src/main/java/com/example/todo/config/filter/LoginCheckFilter.java)를 통해 확인합니다.
  - [관련 TIL](https://subbni.tistory.com/100)
  - 커스텀 어노테이션 [`@CurrentUserId`](https://github.com/subbni/sparta/blob/main/4-todo-jpa/todo/src/main/java/com/example/todo/global/annotation/CurrentUserId.java)를 통해 메서드 파라미터로 현재 로그인 중인 사용자의 id를 받아옵니다.
### 일정 CRUD
- 일정 생성
- 일정 조회 (단건)
  - id로 조회합니다.
- 일정 조회 (전체)
  - size, page 쿼리 파라미터를 통해 페이징을 수행합니다.
  - 파라미터를 지정하지 않을 시 size = 0, page = 10로 수행합니다.
  - 일정 수정일의 내림차순으로 정렬하여 조회합니다.
- 일정 삭제
  - 일정에 달린 댓글들도 함께 삭제합니다.
### 댓글 CRUD
- 댓글 생성
- 댓글 조회 (단건)
  - id로 조회합니다.
- 댓글 수정
  - 내용을 수정합니다.
- 댓글 삭제
  
