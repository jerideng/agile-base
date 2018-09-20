package com.lpcoder.agile.base.bean.container.support

import com.lpcoder.agile.base.bean.container.BeanContainer
import com.lpcoder.agile.base.bean.definition.BeanDefinition
import com.lpcoder.agile.base.bean.exception.BeanCreationException
import com.lpcoder.agile.base.bean.parser.SupportedFileTypeEnum
import com.lpcoder.agile.base.check.alias
import com.lpcoder.agile.base.check.must
import com.lpcoder.agile.base.check.ruler.support.CollRuler.beNotContainsDup
import com.lpcoder.agile.base.core.resource.Resource
import com.lpcoder.agile.base.util.ClassUtil
import java.util.concurrent.ConcurrentHashMap
import java.util.stream.Collectors

class DefaultBeanContainer(resource: Resource) : BeanContainer {

    private val beanDefinitionMap: Map<String, BeanDefinition>
    private val singletonObjMap: Map<String, Any>

    init {
        val beanDefinitions = SupportedFileTypeEnum
                .getBySuffix(resource.getFileSuffix())
                .parser.parse(resource)
        val beanIds = beanDefinitions.stream()
                .map(BeanDefinition::id)
                .collect(Collectors.toList())
        beanIds alias "beanIds" must beNotContainsDup

        beanDefinitionMap = ConcurrentHashMap(64)
        beanDefinitions.stream().forEach { beanDefinitionMap[it.id] = it }

        singletonObjMap = ConcurrentHashMap(64)
        beanDefinitions.stream()
                .filter(BeanDefinition::isSingleton)
                .forEach { singletonObjMap[it.id] = createBean(it) }
    }

    override fun getBeanDefinition(beanId: String): BeanDefinition? {
        return beanDefinitionMap[beanId]
    }

    override fun getBean(beanId: String): Any? {
        val beanDefinition = beanDefinitionMap[beanId]
        if (null == beanDefinition) {
            return null
        }
        if (beanDefinition.isSingleton) {
            return singletonObjMap[beanId]
        }
        return createBean(beanDefinition)
    }

    private fun createBean(beanDefinition: BeanDefinition): Any {
        try {
            return ClassUtil.getDefaultClassLoader()
                    .loadClass(beanDefinition.beanClassName)
                    .newInstance()
        } catch (e: Exception) {
            throw BeanCreationException("create bean for ${beanDefinition.beanClassName} failed", e)
        }
    }

}