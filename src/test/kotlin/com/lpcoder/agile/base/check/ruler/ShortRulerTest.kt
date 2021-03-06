package com.lpcoder.agile.base.check.ruler

import com.lpcoder.agile.base.check.CheckException
import com.lpcoder.agile.base.check.alias
import com.lpcoder.agile.base.check.must
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.eq
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.gt
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.gte
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.lt
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.lte
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.beNotNull
import com.lpcoder.agile.base.check.ruler.support.ShortRuler.beNullVal
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class ShortRulerTest {
    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    private val weight: Short? = 1


    @Test
    fun nullValTest() {
        var num: Short? = null
        num must beNullVal

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17000, desc=num必须为Null")
        num = 1
        num alias "num" must beNullVal
    }

    @Test
    fun notNullTest() {
        var num: Short? = 1
        num must beNotNull

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17006, desc=num不能为Null")
        num = null
        num alias "num" must beNotNull
    }

    @Test
    fun eqTest() {
        weight must eq(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17001, desc=weight必须等于17")
        weight alias "weight" must eq(17)
    }

    @Test
    fun gtTest() {
        weight must gt(0)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17002, desc=weight必须大于17")
        weight alias "weight" must gt(17)
    }

    @Test
    fun gteTest() {
        weight must gte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17003, desc=weight必须大于或等于17")
        weight alias "weight" must gte(17)
    }

    @Test
    fun ltTest() {
        weight must lt(2)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17004, desc=weight必须小于1")
        weight alias "weight" must lt(1)
    }

    @Test
    fun lteTest() {
        weight must lte(1)

        thrown.expect(CheckException::class.java)
        thrown.expectMessage("code=-17005, desc=weight必须小于或等于0")
        weight alias "weight" must lte(0)
    }
}