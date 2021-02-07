package com.example.academy.ui.academy

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setup(){
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getCourse()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}