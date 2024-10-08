package trik.testsys.webclient.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import trik.testsys.webclient.entity.impl.Solution
import trik.testsys.webclient.entity.impl.Student
import trik.testsys.webclient.entity.impl.Task

@Repository
interface SolutionRepository : CrudRepository<Solution, String> {

    fun findSolutionsByTask(task: Task): List<Solution>?

    fun findSolutionsByStudent(student: Student): List<Solution>?

    fun findSolutionsByStudentAndTask(student: Student, task: Task): List<Solution>?
}