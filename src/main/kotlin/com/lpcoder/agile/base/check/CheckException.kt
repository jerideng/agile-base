package com.lpcoder.agile.base.check

/**
 * @author: liurenpeng
 * @date: Created in 18-7-11
 */
class CheckException(var code: Long, var desc: String, var e: CheckException? = null) : Throwable(e) {
    override val message: String?
        get() = "code=${code}, desc=${desc}"
}