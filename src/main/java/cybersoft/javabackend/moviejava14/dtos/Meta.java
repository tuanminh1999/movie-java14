package cybersoft.javabackend.moviejava14.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
public class Meta {
    private long totalElement;
    private int totalPage;
    private int pageSize;
    private int pageNumber;

    public Meta (Page<?> p){
        totalElement = p.getTotalElements();
        totalPage = p.getTotalPages();
        pageSize = p.getSize();
        pageNumber = p.getNumber();
    }
}
