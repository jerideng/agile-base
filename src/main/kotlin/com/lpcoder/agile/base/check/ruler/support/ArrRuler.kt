package com.lpcoder.agile.base.check.ruler.support

import com.lpcoder.agile.base.check.CheckResultCodeEnum.*
import com.lpcoder.agile.base.check.and
import com.lpcoder.agile.base.check.ruler.Ruler
import com.lpcoder.agile.base.util.ArrayUtil.isLengthEq
import com.lpcoder.agile.base.util.ArrayUtil.isLengthGt
import com.lpcoder.agile.base.util.ArrayUtil.isLengthGte
import com.lpcoder.agile.base.util.ArrayUtil.isLengthLt
import com.lpcoder.agile.base.util.ArrayUtil.isLengthLte
import com.lpcoder.agile.base.util.ArrayUtil.isNotContainsDup
import com.lpcoder.agile.base.util.ArrayUtil.isNotContainsNull
import com.lpcoder.agile.base.util.ArrayUtil.isNotEmpty

/**
 * @author: liurenpeng
 * @date: Created in 18-7-12
 */
object ArrRuler {

    val beNullVal = nullVal()
    val beNotNull = notNull()
    val beNotEmpty = notEmpty()
    val beNotContainsNull = notContainsNull()
    val beNotContainsDup = notContainsDup()

    fun nullVal(code: Long = ARR_NULL_FAIL.code, desc: String = ARR_NULL_FAIL.desc)
            = Ruler.ofNullVal<Array<*>?>(code, desc)

    fun notNull(code: Long = ARR_NOT_NULL_FAIL.code, desc: String = ARR_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Array<*>?>(code, desc)

    fun notEmpty(code: Long = ARR_NOT_EMPTY_FAIL.code, desc: String = ARR_NOT_EMPTY_FAIL.desc)
            = beNotNull and Ruler.of(code, desc, ::isNotEmpty)

    fun lengthEq(norm: Int, code: Long = ARR_LENGTH_EQ_FAIL.code, desc: String = ARR_LENGTH_EQ_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, ::isLengthEq)

    fun lengthGt(norm: Int, code: Long = ARR_LENGTH_GT_FAIL.code, desc: String = ARR_LENGTH_GT_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, ::isLengthGt)

    fun lengthGte(norm: Int, code: Long = ARR_LENGTH_GTE_FAIL.code, desc: String = ARR_LENGTH_GTE_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, ::isLengthGte)

    fun lengthLt(norm: Int, code: Long = ARR_LENGTH_LT_FAIL.code, desc: String = ARR_LENGTH_LT_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, ::isLengthLt)

    fun lengthLte(norm: Int, code: Long = ARR_LENGTH_LTE_FAIL.code, desc: String = ARR_LENGTH_LTE_FAIL.desc)
            = beNotNull and Ruler.of(norm, code, desc, ::isLengthLte)

    fun notContainsNull(code: Long = ARR_NOT_CONTAINS_NULL_FAIL.code, desc: String = ARR_NOT_CONTAINS_NULL_FAIL.desc)
            = beNotNull and Ruler.of(code, desc, ::isNotContainsNull)

    fun notContainsDup(code: Long = ARR_NOT_CONTAINS_DUP_FAIL.code, desc: String = ARR_NOT_CONTAINS_DUP_FAIL.desc)
            = beNotNull and Ruler.of(code, desc, ::isNotContainsDup)
}


