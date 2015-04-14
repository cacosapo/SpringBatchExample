package com.mkyong;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:spring/batch/jobs/job-hello-world.xml",
    "classpath:spring/batch/config/test-context.xml"})
public class AppTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
    
    @Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    private JobExplorer jobExplorer;
    
    @Autowired
    @Qualifier("helloWorldJob")
    private Job job;


    
    @Test
    public void launchJob() throws Exception {

    	JobExecution execution = jobLauncher.run(job, new JobParameters());
    	System.out.println("Exit Status : " + execution.getStatus());
//    	jobLauncher.run(job, new JobParameters());
    	
    	List<JobInstance> jobInstances = jobExplorer.getJobInstances("helloWorldJob", 0, 30);
        for (JobInstance jobInstance : jobInstances) {
                System.out.println(jobInstance.getId() + " - "+jobInstance.getJobName());
                List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
                for (JobExecution jobExecution : jobExecutions) {
                        System.out.println("JobExecutions:");
                        System.out.println(" - "+jobExecution.getId()+" - "+jobExecution.getExitStatus());
                        
                        Collection<StepExecution> stepExecutions = jobExecution.getStepExecutions();
                        System.out.println("    StepExecutions:");
                        for (StepExecution stepExecution : stepExecutions) {
                                System.out.println("     - "+stepExecution.getStepName()+" - "+stepExecution.getSummary());
                        }
                }
        }
    	
    	jobExplorer.getJobInstances("helloWorldJob", 0, 0);

//        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        //JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
        
//        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        
    }
}
