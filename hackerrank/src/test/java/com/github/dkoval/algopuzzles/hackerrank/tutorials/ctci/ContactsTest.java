package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Tests {@link Contacts} solution.
 */
@RunWith(Parameterized.class)
public class ContactsTest {
    private final Set<String> words;
    private final Map<String, Integer> matchingPrefixes;

    public ContactsTest(Set<String> words, Map<String, Integer> matchingPrefixes) {
        this.words = words;
        this.matchingPrefixes = matchingPrefixes;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    new HashSet<String>() {{
                        add("hack");
                        add("hackerrank");
                    }},
                    new HashMap<String, Integer>() {{
                        put("hac", 2);
                        put("hak", 0);
                    }}
                },

                {
                    new HashSet<String>() {{
                        add("s");
                        add("ss");
                        add("sss");
                        add("ssss");
                        add("sssss");
                    }},
                    new HashMap<String, Integer>() {{
                        put("s", 5);
                        put("ss", 4);
                        put("sss", 3);
                        put("ssss", 2);
                        put("sssss", 1);
                        put("ssssss", 0);
                    }}
                },
        });
    }

    @Test
    public void matchPrefixes() throws Exception {
        Contacts.Trie t = new Contacts.Trie();
        words.forEach(t::add);
        matchingPrefixes.forEach((prefix, count) -> {
            int numMatches = t.find(prefix);
            assertThat(numMatches, equalTo(matchingPrefixes.get(prefix)));
        });
    }
}