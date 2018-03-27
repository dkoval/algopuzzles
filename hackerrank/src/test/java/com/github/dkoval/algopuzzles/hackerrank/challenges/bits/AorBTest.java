package com.github.dkoval.algopuzzles.hackerrank.challenges.bits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link AorB} solution.
 */
@RunWith(Parameterized.class)
public class AorBTest {
    private final int k;
    private final String a;
    private final String b;
    private final String c;
    private final AorB.Answer expected;

    public AorBTest(int k, String a, String b, String c, AorB.Answer expected) {
        this.k = k;
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {8, "2B", "9F", "58", new AorB.Answer("8", "58")},
                {5, "B9", "40", "5A", new AorB.Answer("18", "42")},
                {2, "91", "BE", "A8", null},
                //
                {95, "28A0879F9420D6B4EFDFF9E462334FE0791", "40AF9E19C84063D52646C69FB9EB07C0770", "451A19E102E5459B1041BDF6E63EDAEDF07", new AorB.Answer("181002044900041B9E462324AE0701", "451A186102C5419B10408496A42E92CDF06")},
                {13, "962981FC68778C8397A7DD6A74864F7E5A7", "BB6A1F187D1B785E6240998FD87BD13BC95", "7865046BBF0952E5B7EA4610323EEC3B5A1", null},
                {2, "A790B0DFC98FAA06254E716C5E04803E419", "106221775CB7B545EB50E4025DDAF96649F", "B7F2B1FFDDBFBF47EF5EF56E5FDEF97E49F", new AorB.Answer("2790B0DFC98FAA06254E716C5E04803E419", "906221775CB7B545EB50E4025DDAF96649F")},
                //
                {251, "5A302CEBBF618BEF55645BBC1AFD79C03F05BE16E7862", "457BCC077D82C59529919ED8F366BC8210DDCE43BD572", "8D4766143946FA2B34C31AFFE2AB82E6F2E58F9B8D278", new AorB.Answer("0", "8D4766143946FA2B34C31AFFE2AB82E6F2E58F9B8D278")},
                {172, "1B8EE98D97F32750E43C9BB37309A8DC35A1E3E7AEBC5", "DD350FEBA12D2B7A83EDEFC1E3BCE71F4544420F42C6E", "8067E45E06C3182991DE523722B4E12229A0DFED6A072", new AorB.Answer("1E52A040", "8067E45E06C3182991DE523722B4E12229A0DE0D42072")},
                {76, "4C3EA80D02FB6ED90F2AFFAEC08C7BF87261B6FB8E6EC", "C7D297281041819301A27CDDB859F362B354A7DC71DF2", "2327D5E92B4B0EA44CF713180DF2BF41279FC79E3D93B", null},
                {53, "9F0661A8AA59C0812A8BA423250C9CF0BF7211ABBF480", "49271D15F47553E13EC25E368E283A803A747996D0B24", "F37809DED47B6FE07E31678F0EC0AF432BB25912D8D37", null},
                {4, "7E607DCF2DE21420A8DD898FC7D2E7EE59061D839F447", "BAFDF5DB3D07497EE094A49ADAAE60787268F9C4A613B", "FEFDFDDF3DE75D7EE8DDAD9FDFFEE7FE7B6EFDC7BF57F", new AorB.Answer("E607DCF2DE21420A8DD898FC7D2E7EE59061D839F447", "FAFDF5DB3D07497EE094A49ADAAE60787268F9C4A613B")},
        });
    }

    @Test
    public void solution() {
        AorB.Answer actual = AorB.solve(k, a, b, c);
        assertThat(actual, equalTo(expected));
    }
}