package com.lpcoder.agile.base.check.ruler.support

import com.lpcoder.agile.base.check.CheckResultCodeEnum.*
import com.lpcoder.agile.base.check.and
import com.lpcoder.agile.base.check.ruler.Ruler
import com.lpcoder.agile.base.util.NumberUtil

object DoubleRuler {
    val beNotNull = notNull()
    val beNullVal = nullVal()

    fun nullVal(code: Long = DOUBLE_NULL_FAIL.code, desc: String = DOUBLE_NULL_FAIL.desc)
            = Ruler.ofNullVal<Double?>(code, desc)

    fun notNull(code: Long = DOUBLE_NOT_NULL_FAIL.code, desc: String = DOUBLE_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Double?>(code, desc)

    fun eq(norm: Double, code: Long = DOUBLE_EQ_FAIL.code, desc: String = DOUBLE_EQ_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, NumberUtil::isEq)

    fun gt(norm: Double, code: Long = DOUBLE_GT_FAIL.code, desc: String = DOUBLE_GT_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, NumberUtil::isGt)

    fun gte(norm: Double, code: Long = DOUBLE_GTE_FAIL.code, desc: String = DOUBLE_GTE_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, NumberUtil::isGte)

    fun lt(norm: Double, code: Long = DOUBLE_LT_FAIL.code, desc: String = DOUBLE_LT_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, NumberUtil::isLt)

    fun lte(norm: Double, code: Long = DOUBLE_LTE_FAIL.code, desc: String = DOUBLE_LTE_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, NumberUtil::isLte)
}