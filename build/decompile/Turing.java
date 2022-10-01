/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

public final class Turing {
    public static final void main() {
        int[] array = new int[]{2, 1, 3};
        int var1 = Turing.solutionB(array, 2);
        System.out.println(var1);
        CollectionsKt.plus((Collection)ArraysKt.distinct((int[])array), (Object)1);
    }

    public static void main(String[] var0) {
        Turing.main();
    }

    public static final int solutionB(int[] A, int S) {
        boolean var11;
        List it;
        boolean $i$f$filterTo;
        ArrayList destination$iv$iv;
        boolean $i$f$filter;
        List $this$filter$iv;
        Intrinsics.checkNotNullParameter((Object)A, (String)"A");
        List var10000 = Turing.subsets(A);
        if (var10000 != null) {
            $this$filter$iv = var10000;
            $i$f$filter = false;
            destination$iv$iv = new ArrayList();
            $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filter$iv) {
                it = (List)element$iv$iv;
                var11 = false;
                List var12 = it;
                if (var12.isEmpty()) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            var10000 = destination$iv$iv;
        } else {
            var10000 = null;
        }
        Intrinsics.checkNotNull((Object)var10000);
        $this$filter$iv = var10000;
        $i$f$filter = false;
        destination$iv$iv = new ArrayList();
        $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filter$iv) {
            it = (List)element$iv$iv;
            var11 = false;
            int var14 = CollectionsKt.sumOfInt((Iterable)it) / it.size();
            System.out.println(var14);
            var14 = CollectionsKt.sumOfInt((Iterable)it);
            if (Math.abs(var14) / it.size() != S) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List subSets = destination$iv$iv;
        System.out.println(subSets);
        double var15 = subSets.size();
        double var13 = 10.0;
        double var5 = 9.0;
        if (var15 > Math.pow(var13, var5)) {
            var13 = 10.0;
            var5 = 9.0;
            return (int)Math.pow(var13, var5);
        }
        return subSets.size();
    }

    public static final List subsets(int[] nums) {
        Intrinsics.checkNotNullParameter((Object)nums, (String)"nums");
        ArrayList list = new ArrayList();
        Turing.getMiniSubset(list, new ArrayList(), nums, 0);
        return list;
    }

    private static final void getMiniSubset(List list, List resultList, int[] nums, int start) {
        list.add(new ArrayList(resultList));
        int var5 = nums.length;
        for (int i = start; i < var5; ++i) {
            resultList.add(nums[i]);
            Turing.getMiniSubset(list, resultList, nums, i + 1);
            resultList.remove(resultList.size() - 1);
        }
    }
}
