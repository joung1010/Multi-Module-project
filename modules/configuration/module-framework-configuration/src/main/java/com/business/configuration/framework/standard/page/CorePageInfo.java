package com.business.configuration.framework.standard.page;

import com.business.configuration.framework.standard.page.enums.SortType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.List;

/**
 * <b> CorePageInfo </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-23
 */

@Getter
@SuperBuilder
public class CorePageInfo implements PageItem{

    @Builder.Default
    private int pageNo = 1;

    @Builder.Default
    private int pageSize = 10;

    @Builder.Default
    private List<DefaultSort> sorts = Collections.emptyList();


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DefaultSort implements SortItem {
        private String sortField;
        private String sortType;


        public static DefaultSortBuilder builder() {
            return new DefaultSortBuilder();
        }

        public static class DefaultSortBuilder {
            private String sortField;
            private String sortType;

            public DefaultSortBuilder sortField(final String sortField) {
                this.sortField = sortField;
                return this;
            }

            public DefaultSortBuilder sortType(final String sortType) {
                this.sortType = SortType.findAndValidSortType(sortType);
                return this;
            }

            public DefaultSort build() {
                return new DefaultSort(sortField, sortType);
            }
        }
    }
}
