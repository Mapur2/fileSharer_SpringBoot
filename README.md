
````markdown
# 📁 File Sharing App

A minimal, secure, and temporary file-sharing web application built with **Spring Boot**.  
Users can upload files and get a unique UID, which can be used to download the file.  
All files expire automatically **after 10 minutes** for privacy and cleanup.

---

## 🚀 Features

- 🔐 **Secure File Upload** via REST API
- 📎 **UID-based File Download**
- ⏲️ Files auto-deleted after **10 minutes**
- 💡 Lightweight UI (with `index.html`)
- 🛡️ Works with any file type (PDF, ZIP, PNG, etc.)

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot (Java)
- **Frontend**: Vanilla HTML + JS (optional React/Thymeleaf possible)
- **Scheduling**: Spring Scheduler (`@Scheduled`)
- **Storage**: In-memory metadata + local temp file storage

---

## 🔧 Setup Instructions

### 📁 1. Clone the Repo

```bash
git clone https://github.com/yourusername/file-sharing-app.git
cd file-sharing-app
````

### ⚙️ 2. Open in your IDE (IntelliJ, VS Code, etc.)

### 📦 3. Install Dependencies via Spring Initializr

Add the following dependencies:

* **Spring Web**
* **Spring Boot DevTools**
* **Lombok** (optional)
* **Spring Configuration Processor**

### ▶️ 4. Run the App

```bash
./mvnw spring-boot:run
```

or run `FileSharingAppApplication.java` in your IDE.

---

## 🌐 API Endpoints

### 📤 `POST /api/upload`

Upload a file:

**Request:**

* Content-Type: `multipart/form-data`
* Field name: `file`

**Response:**

```
<UID>
```

---

### 📥 `GET /api/download/{uid}`

Download a file using UID (valid for 10 minutes).

**Example:**

```
GET /api/download/8ab7e1e9-...-44a9c8
```

---

## 💻 Web Interface

You can use the simple UI at:

```
http://localhost:8080/
```

> HTML file is located at `src/main/resources/static/index.html`

---

## 🧹 Auto-Deletion

The scheduler runs every 1 minute and removes all files older than **10 minutes**.

---

## ✍️ Author

Developed by [**Rupam Modak**](https://mapur2.github.io/new_portfolio/)
