package net.dd.exception;


import lombok.extern.slf4j.Slf4j;
import net.dd.common.Result;
import net.dd.dto.APIResult;
import net.dd.dto.ResultGenerator;
import net.dd.enums.ApiEnum;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

@Slf4j
@RestControllerAdvice  //全局捕获
@ResponseBody
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //Riptide exception
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handler(ShiroException e){
        log.error("shiro异常：--------{}",e);
        return  Result.fail(401,e.getMessage(),null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.error("运行时异常：--------{}",e);
        return  Result.fail(e.getMessage());
    }

    /**
     * 统一异常处理
     * @param e 异常
     * @return 错误500
     */
//    @ExceptionHandler(value = Exception.class)
//    public APIResult exceptionHandler(Exception e) {
//        // 打印调用栈信息
//        e.printStackTrace();
//        if (e instanceof GlobalException) {
//            GlobalException globalException = (GlobalException)e;
//            if (globalException.getApiEnum() == null)
//                return ResultGenerator.genFailed();
//            return ResultGenerator.genFailed(globalException.getApiEnum());
//        }
//        // 还可以接其他异常
//        return ResultGenerator.genFailed();
//    }
//
//    @ExceptionHandler(value = ArithmeticException.class)
//    public APIResult arithmeticExceptionHandler(ArithmeticException e) {
//        e.printStackTrace();
//        return ResultGenerator.genFailed(ApiEnum.DIVIDE_BY_ZERO);
//    }
//
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public APIResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//
//        // 这里在构造错误信息
//        StringBuilder sb = new StringBuilder();
//        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
//        boolean first = true;
//        for (ObjectError error : allErrors) {
//            if (first) first = false;
//            else sb.append(",");
//            sb.append(error.getDefaultMessage());
//        }
//        // 返回错误信息
//        return ResultGenerator.genFailed(sb.toString());
//    }
//
//    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
//    public APIResult maxUploadSizeExceededException(MaxUploadSizeExceededException e) {
//        return ResultGenerator.genFailed(ApiEnum.FILE_SIZE_EXCEEDED);
//    }

}
