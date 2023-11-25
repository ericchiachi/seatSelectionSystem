# seatSelectionSystem

## 完成部分說明

不好意思，因為繳交期限內有其他工作需處理，本測驗僅完成後端部分，前端尚未實作。

若您有興趣查看完成的後端程式，我將於下面章節說明實作上的 3 個 Use Case。透過些 Use Case 應可以搭配前端完成文件內的功能需求。

已經預寫`Repository/DataConfig.class`，執行時將有預設 Employee 與 Seat 資料於 DB 提供檢視

此外，因為時間不足，也僅針對 Entity 進行 Unit Testing

### 1. 查看當前座位表

透過 `api/v1/employee/seat` get 請求，您將獲得一個 List of Seats, 單一 Seat 資料格式為`{"seatId","employeeId","floorNumber","seatNumber"}`，且若沒有員工使用該座位，`employeeId`欄位呈現-1

### 2. 取得沒有座位的員工列表

透過 `api/v1/employee` get 請求，您將獲得一個 List of Employees, 單一 Employee 資料格式為`{"id","name","email"}`

### 3. 更新員工座位

夠過 `/api/v1/employee/seat` post 請求，並且附帶 JSON `{"EmployeeId":"SeatId"}`，您將可以更新座位表資料，且若要取消劃位 SeatId 帶入`-1`即可

## 技術需求

- [未完成]使用 Vue.js 做為前端技術
- [完成]使用 SpringBoot 搭建相關應用程式
- [完成]使用 RESTfulAPI 風格建立後端服務
- [完成]使用 Maven 或 Gradle 做為專案建立的工具。
- [未完成]透過 Stored Procedure 存取資料庫。
- [完成]需同時異動多個資料表時，請實作 Transaction，避免資料錯亂（透過 Springboot@Transactions 實作）
- [未完成]資料庫的 DDL 和 DML 請存放在專案下的\DB 資料夾內提供。
- [部分完成]需防止 SQL Injection 以及 XSS 攻擊(SQL Injection 透過 spring data JPA 避免，XSS 尚未避免)
