# CH 3 일정 관리 앱 과제
## 프로젝트 정보
### 개발 기간
`2025.01.23` ~ `2025.02.03`
### 개발 인원
1인 (개인)
### 설명

### 사용 기술
![](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white")
![](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white)
![](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
![](https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white")

### 파일 구조

---

## API 명세
### Notion에서 보기 : [Link](https://www.notion.so/184a2f5349be800b9321cb2c37b72b6b?v=184a2f5349be8083a94f000c0d93bbfd&pvs=4)

<table class="collection-content">
          <thead>
            <tr>
              <th>
                <span class="icon property-icon"
                  ><svg
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
              <th>
                <span class="icon property-icon"
                  ><svg
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
                >비고
              </th>
            </tr>
          </thead>
          <tbody>
            <tr id="184a2f53-49be-80e4-aca8-cfff48cd3d7f">
              <td class="cell-title">
                <a>일정 생성</a>
              </td>
              <td class="cell-oWjl">
                <span class="selected-value select-value-color-yellow"
                  >POST</span
                >
              </td>
              <td class="cell-TYg\"><code>/api/todo</code></td>
              <td class="cell-&lt;O;_">
                {<br />&quot;content&quot; : &quot;내용&quot;,<br />&quot;email&quot;
                : &quot;<br /><a>test@gmail.com</a
                >&quot;,<br />&quot;userName&quot;: &quot;테스트&quot;,<br />&quot;password&quot;:
                &quot;password&quot;<br />}<br />
              </td>
              <td class="cell-\PJh">
                {<br />&quot;id&quot;: 1,<br />&quot;content&quot;:
                &quot;내용&quot;,<br />&quot;userName&quot;:
                &quot;테스트&quot;<br />}<br />
              </td>
              <td class="cell-Mm?z">
                <span class="selected-value select-value-color-purple"
                  >200</span
                >
              </td>
              <td class="cell-G@X&lt;"></td>
            </tr>
            <tr id="184a2f53-49be-80c5-9196-e5ab782ba201">
              <td class="cell-title">
                <a>일정 조회 (단일)</a>
              </td>
              <td class="cell-oWjl">
                <span class="selected-value select-value-color-blue">GET</span>
              </td>
              <td class="cell-TYg\"><code>/api/todo</code>/{todoId}</td>
              <td class="cell-&lt;O;_"></td>
              <td class="cell-\PJh">
                {<br />&quot;id&quot;: 1,<br />&quot;content&quot;:
                &quot;내용&quot;,<br />&quot;userId&quot;: 1,<br />&quot;userName&quot;:
                &quot;테스트&quot;,<br />&quot;createdAt&quot;:
                &quot;2025-01-31T13:35:57&quot;,<br />&quot;updatedAt&quot;:
                &quot;2025-02-03T16:41:57&quot;<br />}<br />
              </td>
              <td class="cell-Mm?z">
                <span class="selected-value select-value-color-purple"
                  >200</span
                >
              </td>
              <td class="cell-G@X&lt;"></td>
            </tr>
            <tr id="184a2f53-49be-808f-bf6e-ebf513cb2fe6">
              <td class="cell-title">
                <a>일정 목록 조회</a>
              </td>
              <td class="cell-oWjl">
                <span class="selected-value select-value-color-blue">GET</span>
              </td>
              <td class="cell-TYg\">
                <code>/api/todo</code
                >?<br />updatedAt={updatedAt}<br />&amp;userName={userName}<br />&amp;size=3<br />&amp;page=0<br />
              </td>
              <td class="cell-&lt;O;_"></td>
              <td class="cell-\PJh">
                {<br />&quot;data&quot;: [<br />{<br />&quot;id&quot;: 1,<br />&quot;content&quot;:
                &quot;내용&quot;,<br />&quot;userId&quot;: 1,<br />&quot;userName&quot;:
                &quot;테스트&quot;,<br />&quot;createdAt&quot;:
                &quot;2025-01-31T13:35:57&quot;,<br />&quot;updatedAt&quot;:
                &quot;2025-02-03T16:41:57&quot;<br />},<br />{<br />&quot;id&quot;:
                18,<br />&quot;content&quot;: &quot;내용&quot;,<br />&quot;userId&quot;:
                1,<br />&quot;userName&quot;: &quot;테스트&quot;,<br />&quot;createdAt&quot;:
                &quot;2025-02-03T16:40:24&quot;,<br />&quot;updatedAt&quot;:
                &quot;2025-02-03T16:40:24&quot;<br />},<br />{<br />&quot;id&quot;:
                17,<br />&quot;content&quot;: &quot;내용&quot;,<br />&quot;userId&quot;:
                1,<br />&quot;userName&quot;: &quot;테스트&quot;,<br />&quot;createdAt&quot;:
                &quot;2025-02-03T16:38:34&quot;,<br />&quot;updatedAt&quot;:
                &quot;2025-02-03T16:38:34&quot;<br />}<br />],<br />&quot;size&quot;:
                3,<br />&quot;page&quot;: 0<br />}<br />
              </td>
              <td class="cell-Mm?z">
                <span class="selected-value select-value-color-purple"
                  >200</span
                >
              </td>
              <td class="cell-G@X&lt;">
                - 결과는 <code>updated_at</code> 기준 내림차순 정렬<br />- 모든
                파라미터는 <br /><code>required = false</code>
              </td>
            </tr>
            <tr id="184a2f53-49be-8067-84b6-efcc5f24a1ff">
              <td class="cell-title">
                <a>일정 수정</a>
              </td>
              <td class="cell-oWjl">
                <span class="selected-value select-value-color-pink">PUT</span>
              </td>
              <td class="cell-TYg\"><code>/api/todo</code>/{todoId}</td>
              <td class="cell-&lt;O;_">
                {<br />&quot;todoId&quot; : 18,<br />&quot;content&quot; :
                &quot;수정 내용&quot;,<br />&quot;userName&quot;: &quot;수정
                이름&quot;,<br />&quot;password&quot;: &quot;password&quot;<br />}<br />
              </td>
              <td class="cell-\PJh">
                {<br />&quot;id&quot;: 18,<br />&quot;content&quot;: &quot;수정
                내용&quot;,<br />&quot;userName&quot;: &quot;수정 이름&quot;<br />}<br />
              </td>
              <td class="cell-Mm?z">
                <span class="selected-value select-value-color-purple"
                  >200</span
                >
              </td>
              <td class="cell-G@X&lt;"></td>
            </tr>
            <tr id="184a2f53-49be-803c-9b95-f214eb1f8060">
              <td class="cell-title">
                <a>일정 삭제</a>
              </td>
              <td class="cell-oWjl">
                <span class="selected-value select-value-color-gray"
                  >DELETE</span
                >
              </td>
              <td class="cell-TYg\"><code>/api/todo</code>/{todoId}</td>
              <td class="cell-&lt;O;_">
                {<br />&quot;id&quot;:5,<br />&quot;password&quot;:&quot;password&quot;<br />}<br />
              </td>
              <td class="cell-\PJh">-</td>
              <td class="cell-Mm?z">
                <span class="selected-value select-value-color-purple"
                  >200</span
                >
              </td>
              <td class="cell-G@X&lt;"></td>
            </tr>
          </tbody>
        </table>

## ERD
<img width="700" alt="일정관리erd" src="https://github.com/user-attachments/assets/65ed6032-729c-4d4d-a1b6-30dc894a71f5" />



## 🗒️ 구현 내용
