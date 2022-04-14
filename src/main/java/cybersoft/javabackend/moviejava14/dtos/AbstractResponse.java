package cybersoft.javabackend.moviejava14.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbstractResponse {
    private boolean isSuccess = true;
    private Object data;
    private Integer errorCode;
    private Meta meta;

    public AbstractResponse(Object data){
        this.data = data;
    }

    public AbstractResponse(Object data, Meta meta){
        this.data = data;
        this.meta = meta;
    }

    public AbstractResponse(Integer errorCode){
        isSuccess = false;
        this.errorCode = errorCode;
    }
}
