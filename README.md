# [WEB APPLICATION - QUẢN LÝ DỰ ÁN NHÓM LỚP](https://github.com/nguyenhuykhai/manager-tasks-application)

FU_MANAGER_PROJECT (Back-end) là một ứng dụng web được thiết kế và phát triển để hỗ trợ quản lý dự án nhóm lớp cho sinh viên tại Trường Đại học FPT xây dựng bởi 2 sinh viên FPT. Dự án này nhằm mục đích tạo ra một nền tảng trực tuyến giúp sinh viên và giáo viên theo dõi, quản lý, và tương tác trong quá trình thực hiện các dự án nhóm trong quá trình học tập.

---

# Yêu Cầu Môi Trường để Chạy Dự Án | Setup Instructions

1. **Spring boot compiler**

   - Bất kì compiler nào chạy được spring boot đều có thể khởi động dự án, ví dụ : Intellij, Eclipse ,...

4. **Chạy Dự Án | Run the Project:**
   - Khởi động compiler. ( Lưu ý chạy toàn bộ các dependencies trong file pom.xml trước )
   - Truy cập ứng dụng tại `http://localhost:3000/` trong trình duyệt web của bạn.

---

## Dưới đây là một số tính năng chính của ứng dụng | Application

1. Quản lý Dự Án:
Tạo Dự Án: Sinh viên hoặc giảng viên có thể tạo dự án mới, đặt tên, mô tả và xác định mục tiêu của dự án.
Quản lý Tiến Độ (Process): Hệ thống theo dõi tiến độ của dự án, cho phép người dùng thêm, chỉnh sửa và xóa các bước trong quy trình làm việc.

2. Quản lý Sprint:
Tạo Sprint: Định kỳ tạo Sprint để quản lý công việc trong khoảng thời gian cố định.
Gán Công Việc: Sinh viên có thể tự gán công việc cho mình trong mỗi Sprint, và giảng viên có thể gán công việc cho từng nhóm hoặc sinh viên.

3. Feedback và Chấm Điểm:
Phản Hồi (Feedback): Sinh viên có thể nhận phản hồi từ giảng viên và thành viên khác trong nhóm về công việc của họ.
Chấm Điểm: Giảng viên có thể chấm điểm cho từng công việc hoặc dự án, cung cấp điểm số và phản hồi chi tiết.

4. Quản lý theo Nhóm:
Tạo Nhóm: Sinh viên có thể tự tạo nhóm hoặc được phân nhóm tự động.
Giao Việc trong Nhóm: Khả năng phân công công việc, theo dõi tiến độ và phản hồi được thực hiện theo nhóm.

5. Chat Real-time:
Chat Nhóm: Sinh viên và giảng viên có thể thảo luận và trao đổi ý kiến trong các cuộc trò chuyện nhóm.
Chat Riêng: Khả năng trò chuyện riêng tư giữa sinh viên và giảng viên.

6. Thông Báo và Lịch Nhắc:
Thông Báo Tự Động: Gửi thông báo về các sự kiện quan trọng như deadline, sự kiện mới, hoặc phản hồi từ giảng viên.
Lịch Nhắc: Tự động tạo lịch nhắc cho các sự kiện trong Sprint hoặc Dự Án.

7. Tương Tác và Giao Tiếp:
Tương Tác Tương Đối: Khả năng tương tác dễ dàng và linh hoạt giữa sinh viên và giảng viên.
Giao Tiếp Thông Qua Tác Vụ (Task-based Communication): Có thể gửi tin nhắn, thảo luận trực tiếp trên công việc hoặc nhiệm vụ cụ thể.

8. Bảo Mật và Quyền Truy Cập:
Quản lý Quyền Truy Cập: Xác định quyền truy cập của từng người dùng (sinh viên, giảng viên) đối với các tính năng cụ thể.
Bảo Mật Thông Tin: Đảm bảo an toàn và bảo mật thông tin của sinh viên và dữ liệu dự án.

9. Báo Cáo và Thống Kê:
Báo Cáo Tiến Độ: Cung cấp báo cáo tự động về tiến độ dự án, công việc đã hoàn thành và chưa hoàn thành.
Thống Kê Điểm Số: Hiển thị điểm số tổng kết và thống kê chi tiết về điểm số của sinh viên.

10. Đa Nền Tảng và Đa Thiết Bị:
Responsive Design: Ứng dụng có giao diện phản hồi, phù hợp với mọi loại thiết bị.
Hỗ Trợ Đa Trình Duyệt: Đảm bảo hoạt động trơn tru trên các trình duyệt phổ biến.

- Dự án này giúp tăng cường tương tác và hợp tác giữa sinh viên trong quá trình học tập, đồng thời cung cấp cho giáo viên công cụ quản lý hiệu quả để đánh giá và hỗ trợ quá trình phát triển kỹ năng làm việc nhóm của sinh viên.

---

## Cấu trúc dự án | Project Structure

```plaintext
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---example
|   |   |           \---ProTaskifyAPI
|   |   |               |   ProTaskifyApiApplication.java
|   |   |               |
|   |   |               +---config
|   |   |               |       ApplicationConfig.java
|   |   |               |       SecurityConfig.java
|   |   |               |
|   |   |               +---Controllers
|   |   |               |       AuthenticateController.java
|   |   |               |       GroupController.java
|   |   |               |       ProcessController.java
|   |   |               |       ProjectController.java
|   |   |               |       StudentController.java
|   |   |               |
|   |   |               +---DTO
|   |   |               |   |   ClassDTO.java
|   |   |               |   |   FeatureDTO.java
|   |   |               |   |   GroupDTO.java
|   |   |               |   |   LecturerDTO.java
|   |   |               |   |   ProcessDTO.java
|   |   |               |   |   ResponseObject.java
|   |   |               |   |   StudentDTO.java
|   |   |               |   |   TaskDTO.java
|   |   |               |   |
|   |   |               |   +---Response
|   |   |               |   |       AuthenticationResponse.java
|   |   |               |   |       GroupProjectDetailsDTO.java
|   |   |               |   |       ListStudentResponse.java
|   |   |               |   |       ProcessDetailsResponse.java
|   |   |               |   |       TotalTasksResponse.java
|   |   |               |   |
|   |   |               |   \---Resquest
|   |   |               |           AuthenticationRequest.java
|   |   |               |           UpdateLinkRequest.java
|   |   |               |
|   |   |               +---enums
|   |   |               |       Permission.java
|   |   |               |       Role.java
|   |   |               |       TokenType.java
|   |   |               |
|   |   |               +---Filter
|   |   |               |       JWTAuthenticationFilter.java
|   |   |               |
|   |   |               +---Models
|   |   |               |       Class.java
|   |   |               |       Feature.java
|   |   |               |       Group.java
|   |   |               |       Lecturer.java
|   |   |               |       Messages.java
|   |   |               |       Process.java
|   |   |               |       ProcessCompositeKey.java
|   |   |               |       Project.java
|   |   |               |       Semester.java
|   |   |               |       Sprint.java
|   |   |               |       Star.java
|   |   |               |       Student.java
|   |   |               |       StudentTask.java
|   |   |               |       StudentTaskCompositeKey.java
|   |   |               |       Task.java
|   |   |               |       Tokens.java
|   |   |               |
|   |   |               +---Repositories
|   |   |               |       ClassRepo.java
|   |   |               |       FeatureRepo.java
|   |   |               |       GroupRepo.java
|   |   |               |       LecturerRepo.java
|   |   |               |       ProcessRepo.java
|   |   |               |       ProjectRepo.java
|   |   |               |       SemesterRepo.java
|   |   |               |       SprintRepo.java
|   |   |               |       StarRepo.java
|   |   |               |       StudentRepo.java
|   |   |               |       StudentTaskRepo.java
|   |   |               |       TaskRepo.java
|   |   |               |       TokensRepo.java
|   |   |               |
|   |   |               +---ServiceImpl
|   |   |               |       AuthenticationServiceImpl.java
|   |   |               |       GroupServiceImpl.java
|   |   |               |       JwtService.java
|   |   |               |       LogoutServiceImpl.java
|   |   |               |       ProcessServiceImpl.java
|   |   |               |       ProjectServiceImpl.java
|   |   |               |       StudentServiceImpl.java
|   |   |               |
|   |   |               \---Services
|   |   |                       AuthenticationService.java
|   |   |                       GroupService.java
|   |   |                       ProcessService.java
|   |   |                       ProjectService.java
|   |   |                       StudentService.java
|   |   |
|   |   \---resources
|   |           application.properties
|   |
|   \---test
|       \---java
|           \---com
|               \---example
|                   \---ProTaskifyAPI
|                           ProTaskifyApiApplicationTests.java
|
\---target
    +---classes
    |   |   application.properties
    |   |
    |   \---com
    |       \---example
    |           \---ProTaskifyAPI
    |               |   ProTaskifyApiApplication.class
    |               |
    |               +---config
    |               |       ApplicationConfig.class
    |               |       SecurityConfig.class
    |               |
    |               +---Controllers
    |               |       AuthenticateController.class
    |               |       GroupController.class
    |               |       ProcessController.class
    |               |       ProjectController.class
    |               |       StudentController.class
    |               |
    |               +---DTO
    |               |   |   ClassDTO$ClassDTOBuilder.class
    |               |   |   ClassDTO.class
    |               |   |   FeatureDTO.class
    |               |   |   GroupDTO$GroupDTOBuilder.class
    |               |   |   GroupDTO.class
    |               |   |   LecturerDTO$LecturerDTOBuilder.class
    |               |   |   LecturerDTO.class
    |               |   |   ListStudentResponse.class
    |               |   |   ProcessDTO.class
    |               |   |   ResponseObject$ResponseObjectBuilder.class
    |               |   |   ResponseObject.class
    |               |   |   StudentDTO$StudentDTOBuilder.class
    |               |   |   StudentDTO.class
    |               |   |   TaskDTO$TaskDTOBuilder.class
    |               |   |   TaskDTO.class
    |               |   |   UpdateLinkRequest$UpdateLinkRequestBuilder.class
    |               |   |   UpdateLinkRequest.class
    |               |   |
    |               |   +---Response
    |               |   |       AuthenticationResponse$AuthenticationResponseBuilder.class
    |               |   |       AuthenticationResponse.class
    |               |   |       GroupProjectDetailsDTO$GroupProjectDetailsDTOBuilder.class
    |               |   |       GroupProjectDetailsDTO.class
    |               |   |       ProcessDetailsResponse.class
    |               |   |       TotalTasksResponse$TotalTasksResponseBuilder.class
    |               |   |       TotalTasksResponse.class
    |               |   |
    |               |   \---Resquest
    |               |           AuthenticationRequest.class
    |               |
    |               +---enums
    |               |       Permission.class
    |               |       Role.class
    |               |       TokenType.class
    |               |
    |               +---Filter
    |               |       JWTAuthenticationFilter.class
    |               |
    |               +---Models
    |               |       Class$ClassBuilder.class
    |               |       Class.class
    |               |       Feature$FeatureBuilder.class
    |               |       Feature.class
    |               |       Group$GroupBuilder.class
    |               |       Group.class
    |               |       Lecturer$LecturerBuilder.class
    |               |       Lecturer.class
    |               |       Messages$MessagesBuilder.class
    |               |       Messages.class
    |               |       Process$ProcessBuilder.class
    |               |       Process.class
    |               |       ProcessCompositeKey$ProcessCompositeKeyBuilder.class
    |               |       ProcessCompositeKey.class
    |               |       Project$ProjectBuilder.class
    |               |       Project.class
    |               |       Semester$SemesterBuilder.class
    |               |       Semester.class
    |               |       Sprint$SprintBuilder.class
    |               |       Sprint.class
    |               |       Star$StarBuilder.class
    |               |       Star.class
    |               |       Student$StudentBuilder.class
    |               |       Student.class
    |               |       StudentTask$StudentTaskBuilder.class
    |               |       StudentTask.class
    |               |       StudentTaskCompositeKey$StudentTaskCompositeKeyBuilder.class
    |               |       StudentTaskCompositeKey.class
    |               |       Task$TaskBuilder.class
    |               |       Task.class
    |               |       Tokens$TokensBuilder.class
    |               |       Tokens.class
    |               |
    |               +---Repositories
    |               |       ClassRepo.class
    |               |       FeatureRepo.class
    |               |       GroupRepo.class
    |               |       LecturerRepo.class
    |               |       ProcessRepo.class
    |               |       ProjectRepo.class
    |               |       SemesterRepo.class
    |               |       SprintRepo.class
    |               |       StarRepo.class
    |               |       StudentRepo.class
    |               |       StudentTaskRepo.class
    |               |       TaskRepo.class
    |               |       TokensRepo.class
    |               |
    |               +---ServiceImpl
    |               |       AuthenticationServiceImpl.class
    |               |       GroupServiceImpl.class
    |               |       JwtService.class
    |               |       LogoutServiceImpl.class
    |               |       ProcessServiceImpl.class
    |               |       ProjectServiceImpl.class
    |               |       StudentServiceImpl.class
    |               |
    |               \---Services
    |                       AuthenticationService.class
    |                       GroupService.class
    |                       ProcessService.class
    |                       ProjectService.class
    |                       StudentService.class
    |
    \---generated-sources
        \---annotations
```

---

## Công nghệ | Technical

- Frontend: React
- Backend: Spring Boot
- Database: SQL Server
- Real-Time Interactions: Firebase
- Containerization: Docker
- Send mail with Nodemailer
- Payment: Paypal, VNPay
- GG Cloud: Login, Gmail API

---

## Tài liệu | Documentation

 [Design Figma](https://github.com/nguyenhuykhai/manager-tasks-application).

 [Function Requirement](https://docs.google.com/document/d/1CPjPpIMVkAp9KRoCvXRMUoL48Fq_O6yInnZExIvpzVI/edit?fbclid=IwAR32KoldKVxeqRD4jj6fraiftt8D1twY8l4e1sg16PIT_dbG97FOcaQiVsI).

 [Task Schedule](https://docs.google.com/spreadsheets/d/1JT4wJQmYRBn1k7oGymkNiErLl3mzwQr-MO5kbobTIZM/edit?usp=sharing).

---

## Demo

- [Đang trong quá trình xây dựng](https://github.com/nguyenhuykhai/manager-tasks-application)

---

## Giao diện FU_MANAGER_PROJECT | FRONTEND

- [FU_MANAGER_PROJECT (Front-end)](https://github.com/nguyenhuykhai/manager-tasks-application)

