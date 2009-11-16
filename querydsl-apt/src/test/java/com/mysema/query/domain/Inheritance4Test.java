package com.mysema.query.domain;

import org.junit.Test;

import com.mysema.query.annotations.QueryEntity;
import com.mysema.query.types.path.PNumber;
import com.mysema.query.types.path.PSimple;
import com.mysema.query.types.path.PString;

public class Inheritance4Test extends AbstractTest{
    
    @QueryEntity
    public class EntityWithComparable {
        private Comparable<?> field;

        public Comparable<?> getField() {
            return field;
        }
        
    }

    @QueryEntity
    public class EntityWithNumber extends EntityWithComparable{
        private Integer field;

        public Integer getField() {
            return field;
        }
        
    }
    
    @QueryEntity
    public class EntityWithString extends EntityWithComparable{
        private String field;

        public String getField() {
            return field;
        }
        
    }
    
    @Test
    public void test() throws SecurityException, NoSuchFieldException{
        cl = QEntityWithComparable.class;
        match(PSimple.class, "field");
        
        cl = QEntityWithNumber.class;
        match(PNumber.class, "field");
        
        cl = QEntityWithString.class;
        match(PString.class, "field");
        
    }
}
