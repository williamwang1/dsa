public class TP_Wrap_Rain_Water {
}



// https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/jie-yu-shui

// https://www.jiuzhang.com/solution/trapping-rain-water/

// https://www.lintcode.com/problem/trapping-rain-water/description

//  我们不要想整体，而应该去想局部 仅仅对于位置 i，能装下多少水呢？

//    位置 i 能达到的水柱高度和其左边的最高柱子、右边的最高柱子有关

//  更进一步，对于位置 i，能够装的水为：

//water[i] = min(
//        # 左边最高的柱子
//        max(height[0..i]),
//        # 右边最高的柱子
//        max(height[i..end])
//        ) - height[i]