package kemy.dev.EmailServiceExample.entities;

public class NotificationDto {
    /** User send data */
    private Long studentId;
    /** Title of the notification */
    private String title;
    /** TExt of the notification */
    private String text;

    public NotificationDto() {
    }

    public NotificationDto(Long studentId, String title, String text) {
        this.studentId = studentId;
        this.title = title;
        this.text = text;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
