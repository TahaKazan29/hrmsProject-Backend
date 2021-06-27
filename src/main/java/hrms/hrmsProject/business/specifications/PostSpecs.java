package hrms.hrmsProject.business.specifications;

import hrms.hrmsProject.entities.concretes.Post;
import hrms.hrmsProject.entities.dtos.PostByFilterDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.Predicate;
public class PostSpecs {

    public static Specification<Post> postFilter(PostByFilterDto postByFilterDto){
        return new Specification<Post>() {
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                final Collection<Predicate> predicates = new ArrayList<>();

                if(postByFilterDto.getCityIds() != null){
                    final Predicate cityPredicate = root.get("city").get("id").in(postByFilterDto.getCityIds());
                    predicates.add(cityPredicate);
                }

                if(postByFilterDto.getPositionIds() != null){
                    final Predicate positionPredicate = root.get("jobPosition").get("id").in(postByFilterDto.getPositionIds());
                    predicates.add(positionPredicate);
                }

                if(postByFilterDto.getWayOfWorkingIds() != null){
                    final Predicate wayOfWorkingPredicate = root.get("wayOfWorking").get("id").in(postByFilterDto.getWayOfWorkingIds());
                    predicates.add(wayOfWorkingPredicate);
                }

                if(postByFilterDto.getWorkingTimeIds() != null){
                    final Predicate workingTimePredicate = root.get("workingTime").get("id").in(postByFilterDto.getWorkingTimeIds());
                    predicates.add(workingTimePredicate);
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
