package org.koin.android.viewmodel

import org.junit.Assert.*
import org.junit.Test
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class ViewModelInstanceTest {

    @Test
    fun `should have a factory instance for ViewModel`() {
        val koinApp = koinApplication {
            printLogger(Level.DEBUG)
            modules(module {
                viewModel { MyViewModel() }
            })
        }
        val koin = koinApp.koin

        val instance1 = koin.get<MyViewModel>()
        val instance2 = koin.get<MyViewModel>()
        assertNotEquals(instance1, instance2)

        val definition = koinApp.getDefinition(MyViewModel::class)
        assertNotNull(definition)
//        val instanceFactory = koin._scopeRegistry.rootScope._instanceRegistry.instances.values.firstOrNull { it.beanDefinition == definition }
//        assertTrue(instanceFactory != null)
    }
}