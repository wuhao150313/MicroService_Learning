package org.example.userservice.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "成功", data);
    }

    public static <T> ApiResponse<T> notFound() {
        return new ApiResponse<>(404, "用户不存在", null);
    }

    public static <T> ApiResponse<T> maintenance() {
        return new ApiResponse<>(503, "用户服务维护中，请稍后", null);
    }
}


