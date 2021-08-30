package geometry

import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        var cx1 = 0
        var cx2 = 0
        var cy1 = 0
        var cy2 = 0

        if (min(ax1, ax2) <= min(bx1, bx2)) {
            if ((max(ax1, ax2) in bx1..bx2) || (max(ax1, ax2) in bx2..bx1)) {
                cx1 = max(ax1, ax2)
                cx2 = min(bx1, bx2)
            } else if (max(ax1, ax2) > max(bx1, bx2)) {
                cx1 = bx1
                cx2 = bx2
            }
        } else {
            if ((max(bx1, bx2) in ax1..ax2) || (max(bx1, bx2) in ax2..ax1)) {
                cx1 = max(bx1, bx2)
                cx2 = min(ax1, ax2)
            } else if (max(bx1, bx2) > max(ax1, ax2)) {
                cx1 = ax1
                cx2 = ax2
            }
        }

        if (min(ay1, ay2) <= min(by1, by2)) {
            if ((max(ay1, ay2) in by1..by2) || (max(ay1, ay2) in by2..by1)) {
                cy1 = max(ay1, ay2)
                cy2 = min(by1, by2)
            } else if (max(ay1, ay2) > max(by1, by2)) {
                cy1 = by1
                cy2 = by2
            }
        } else {
            if ((max(by1, by2) in ay1..ay2) || (max(by1, by2) in ay2..ay1)) {
                cy1 = max(by1, by2)
                cy2 = min(ay1, ay2)
            } else if (max(by1, by2) > max(ay1, ay2)) {
                cy1 = ay1
                cy2 = ay2
            }
        }

        return ((ax1 - ax2).absoluteValue * (ay1 - ay2).absoluteValue) +
                ((bx1 - bx2).absoluteValue * (by1 - by2).absoluteValue) -
                ((cx1 - cx2).absoluteValue * (cy1 - cy2).absoluteValue)
    }
}