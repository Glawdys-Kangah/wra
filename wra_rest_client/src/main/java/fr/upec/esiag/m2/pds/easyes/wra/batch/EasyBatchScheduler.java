package fr.upec.esiag.m2.pds.easyes.wra.batch;





import org.easybatch.core.impl.EasyBatchEngine;
import org.easybatch.integration.quartz.EasyBatchJobFactory;
import org.easybatch.integration.quartz.EasyBatchSchedulerException;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;


/**
 *  Quartz scheduler wrapper used to setup triggers-- to run client
 * @author Glawdys
 *
 */
public class EasyBatchScheduler {

	/**
	 * The name of easy batch job trigger.
	 */
	public static final String EASY_BATCH_JOB_TRIGGER = "easy-batch-job-trigger";

	/**
	 * The name of easy batch job.
	 */
	public static final String EASY_BATCH_JOB = "easy-batch-job";

	/**
	 * The trigger used to fire batch execution.
	 */
	private Trigger trigger;

	/**
	 * Quartz scheduler.
	 */
	private Scheduler scheduler;

	public EasyBatchScheduler(EasyBatchEngine easyBatchEngine) throws EasyBatchSchedulerException {
		JobFactory jobFactory = new EasyBatchJobFactory(easyBatchEngine);
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			scheduler = schedulerFactory.getScheduler();
			scheduler.setJobFactory(jobFactory);
		} catch (SchedulerException e) {
			throw new EasyBatchSchedulerException("An exception occurred during scheduler setup", e);
		}
	}
}
