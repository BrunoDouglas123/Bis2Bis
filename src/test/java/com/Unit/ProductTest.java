package com.Unit;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootConfiguration
public class ProductTest {

    @Test
    public void testAssertList() {
        List<String> actual = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("a", "b", "c");
		
		assertThat(actual, is(expected));

        assertThat(actual, hasItems("b"));

        assertThat(actual, hasSize(3));

        assertThat(actual.size(), is(3));

        assertThat(actual, contains("a", "b", "c"));

        assertThat(actual, containsInAnyOrder("c", "b", "a"));

        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());
    }
}
