package com.bassem.demo_plants.utils

import android.util.Log
import com.bassem.demo_plants.BaseTest
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test

class LoggerTest : BaseTest() {

    private val message = "test"
    private val tag = this::class.java.simpleName
    private lateinit var logger: Logger

    override fun setup() {
        super.setup()
        mockkStatic(Log::class)
        logger = Logger(tag)
    }


    @Test
    fun `test debug log`() {
        logger.d(message)
        verify { Log.d(tag, message) }
    }

    @Test
    fun `test info log`() {
        logger.i(message)
        verify { Log.i(tag, message) }
    }

    @Test
    fun `test error log`() {
        logger.e(message)
        verify { Log.e(tag, message) }
    }
}