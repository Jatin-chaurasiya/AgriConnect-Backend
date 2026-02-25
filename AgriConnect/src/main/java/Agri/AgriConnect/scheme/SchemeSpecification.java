package Agri.AgriConnect.scheme;

import Agri.AgriConnect.Entity.Scheme;
import Agri.AgriConnect.Enum.Category;
import Agri.AgriConnect.Enum.SchemeType;
import org.springframework.data.jpa.domain.Specification;

public class SchemeSpecification {

    public static Specification<Scheme> filterSchemes(
            SchemeType type,
            String state,
            Category category
    ) {
        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (type != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("type"), type));
            }

            if (state != null && !state.isBlank()) {
                predicate = cb.and(predicate,
                        cb.equal(cb.lower(root.get("state")),
                                state.toLowerCase()));
            }

            if (category != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("category"), category));
            }

            return predicate;
        };
    }
}