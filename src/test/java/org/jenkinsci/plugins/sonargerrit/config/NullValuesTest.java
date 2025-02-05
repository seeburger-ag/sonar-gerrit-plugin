package org.jenkinsci.plugins.sonargerrit.config;

import java.util.ArrayList;

import org.jenkinsci.plugins.sonargerrit.SonarToGerritPublisher;
import org.junit.Assert;
import org.junit.Test;

/**
 * Project: Sonar-Gerrit Plugin
 * Author:  Tatiana Didik
 * Created: 19.11.2017 10:23
 * <p>
 * $Id$
 */
public class NullValuesTest implements DetailedConfigTest {

    @Test
    public void testSeverity() {
        IssueFilterConfig config = new IssueFilterConfig();
        config.setSeverity(null);
        Assert.assertEquals(SEVERITY, config.getSeverity());
    }

    public void testNewOnly() {
        // boolean doesn't allow null
    }

    public void testChangedLinesOnly() {
        // boolean doesn't allow null
    }

    @Test
    public void testFilterConfig() {
        ReviewConfig config = new ReviewConfig();
        config.setIssueFilterConfig(null);
        Assert.assertNotNull(config.getIssueFilterConfig());
        Assert.assertEquals(SEVERITY, config.getIssueFilterConfig().getSeverity());
        Assert.assertEquals(NEW_ISSUES_ONLY, config.getIssueFilterConfig().isNewIssuesOnly());
        Assert.assertEquals(CHANGED_LINES_ONLY, config.getIssueFilterConfig().isChangedLinesOnly());

        IssueFilterConfig fconfig = new IssueFilterConfig(null, false, false);
        Assert.assertEquals(SEVERITY, fconfig.getSeverity());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testNoIssuesTitleTemplate() {
        ReviewConfig config = new ReviewConfig();
        config.setNoIssuesTitleTemplate(null);
        Assert.assertEquals(NO_ISSUES_TITLE_TEMPLATE, config.getNoIssuesTitleTemplate());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testSomeIssuesTitleTemplate() {
        ReviewConfig config = new ReviewConfig();
        config.setSomeIssuesTitleTemplate(null);
        Assert.assertEquals(SOME_ISSUES_TITLE_TEMPLATE, config.getSomeIssuesTitleTemplate());
    }

    @Override
    public void testIssuesCommentTemplate() {
        ReviewConfig config = new ReviewConfig();
        config.setIssueCommentTemplate(null);
        Assert.assertEquals(ISSUE_COMMENT_TEMPLATE, config.getIssueCommentTemplate());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testReviewConfig() {
        SonarToGerritPublisher publisher = new SonarToGerritPublisher();
        publisher.setReviewConfig(null);
        ReviewConfig config = publisher.getReviewConfig();
        Assert.assertNotNull(config);
        Assert.assertEquals(NO_ISSUES_TITLE_TEMPLATE, config.getNoIssuesTitleTemplate());
        Assert.assertEquals(SOME_ISSUES_TITLE_TEMPLATE, config.getSomeIssuesTitleTemplate());
        Assert.assertEquals(ISSUE_COMMENT_TEMPLATE, config.getIssueCommentTemplate());
        Assert.assertEquals(SEVERITY, config.getIssueFilterConfig().getSeverity());
        Assert.assertEquals(NEW_ISSUES_ONLY, config.getIssueFilterConfig().isNewIssuesOnly());
        Assert.assertEquals(CHANGED_LINES_ONLY, config.getIssueFilterConfig().isChangedLinesOnly());

        config = new ReviewConfig(null, null, null, null);
        Assert.assertNotNull(config.getIssueFilterConfig());
        Assert.assertEquals(SEVERITY, config.getIssueFilterConfig().getSeverity());
        Assert.assertEquals(NEW_ISSUES_ONLY, config.getIssueFilterConfig().isNewIssuesOnly());
        Assert.assertEquals(CHANGED_LINES_ONLY, config.getIssueFilterConfig().isChangedLinesOnly());
        Assert.assertEquals(NO_ISSUES_TITLE_TEMPLATE, config.getNoIssuesTitleTemplate());
        Assert.assertEquals(SOME_ISSUES_TITLE_TEMPLATE, config.getSomeIssuesTitleTemplate());
        Assert.assertEquals(ISSUE_COMMENT_TEMPLATE, config.getIssueCommentTemplate());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testCategory() {
        ScoreConfig config = new ScoreConfig();
        config.setCategory(null);
        Assert.assertEquals(CATEGORY, config.getCategory());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testNoIssuesScoreScore() {
        ScoreConfig config = new ScoreConfig();
        config.setNoIssuesScore(null);
        Assert.assertEquals(NO_ISSUES_SCORE, config.getNoIssuesScore());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testSomeIssuesScoreScore() {
        ScoreConfig config = new ScoreConfig();
        config.setIssuesScore(null);
        Assert.assertEquals(SOME_ISSUES_SCORE, config.getIssuesScore());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testScoreConfig() {
        SonarToGerritPublisher publisher = new SonarToGerritPublisher();
        publisher.setScoreConfig(null);
        Assert.assertNull(publisher.getScoreConfig());

        ScoreConfig config = new ScoreConfig(null, null, null, null);
        Assert.assertNotNull(config.getIssueFilterConfig());
        Assert.assertEquals(SEVERITY, config.getIssueFilterConfig().getSeverity());
        Assert.assertEquals(NEW_ISSUES_ONLY, config.getIssueFilterConfig().isNewIssuesOnly());
        Assert.assertEquals(CHANGED_LINES_ONLY, config.getIssueFilterConfig().isChangedLinesOnly());
        Assert.assertEquals(CATEGORY, config.getCategory());
        Assert.assertEquals(NO_ISSUES_SCORE, config.getNoIssuesScore());
        Assert.assertEquals(SOME_ISSUES_SCORE, config.getIssuesScore());

    }

    @Test//(expected = IllegalArgumentException.class)
    public void testNoIssuesNotificationRecipient() {
        NotificationConfig config = new NotificationConfig();
        config.setNoIssuesNotificationRecipient(null);
        Assert.assertEquals(NO_ISSUES_NOTIFICATION, config.getNoIssuesNotificationRecipient());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testIssuesNotificationRecipient() {
        NotificationConfig config = new NotificationConfig();
        config.setCommentedIssuesNotificationRecipient(null);
        Assert.assertEquals(ISSUES_NOTIFICATION, config.getCommentedIssuesNotificationRecipient());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testNegativeScoreNotificationRecipient() {
        NotificationConfig config = new NotificationConfig();
        config.setNegativeScoreNotificationRecipient(null);
        Assert.assertEquals(SCORE_NOTIFICATION, config.getNegativeScoreNotificationRecipient());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testNotificationConfig() {
        SonarToGerritPublisher publisher = new SonarToGerritPublisher();
        publisher.setNotificationConfig(null);
        NotificationConfig config = publisher.getNotificationConfig();
        Assert.assertNotNull(config);
        Assert.assertEquals(NO_ISSUES_NOTIFICATION, config.getNoIssuesNotificationRecipient());
        Assert.assertEquals(ISSUES_NOTIFICATION, config.getCommentedIssuesNotificationRecipient());
        Assert.assertEquals(SCORE_NOTIFICATION, config.getNegativeScoreNotificationRecipient());

        config = new NotificationConfig(null, null, "");
        Assert.assertEquals(NO_ISSUES_NOTIFICATION, config.getNoIssuesNotificationRecipient());
        Assert.assertEquals(ISSUES_NOTIFICATION, config.getCommentedIssuesNotificationRecipient());
        Assert.assertEquals(SCORE_NOTIFICATION, config.getNegativeScoreNotificationRecipient());

    }

    @Test//(expected = IllegalArgumentException.class)
    public void testSonarUrl() {
        InspectionConfig config = new InspectionConfig();
        config.setServerURL(null);
        Assert.assertEquals(SONAR_URL, config.getServerURL());
    }

    @Test
    public void testSonarReportPath() {
        SubJobConfig config = new SubJobConfig();
        Assert.assertEquals(SONAR_REPORT_PATH, config.getSonarReportPath());
        config.setSonarReportPath(null);
        Assert.assertEquals(SONAR_REPORT_PATH, config.getSonarReportPath());
    }

    @Test//(expected = IllegalArgumentException.class)
    public void testInspectionConfig() {
        SonarToGerritPublisher publisher = new SonarToGerritPublisher();
        publisher.setInspectionConfig(null);
        InspectionConfig config = publisher.getInspectionConfig();
        Assert.assertNotNull(config);
        Assert.assertEquals(SONAR_URL, config.getServerURL());
        Assert.assertEquals(SONAR_REPORT_PATH, config.getBaseConfig().getSonarReportPath());
        Assert.assertEquals(PROJECT_PATH, config.getBaseConfig().getProjectPath());
        Assert.assertEquals(PATH_AUTO_MATCH, config.getBaseConfig().isAutoMatch());
        Assert.assertEquals(PATH_AUTO_MATCH, config.isAutoMatchforPullRequest());
        Assert.assertNotNull(config.getSubJobConfigs());
        Assert.assertEquals(1, config.getSubJobConfigs().size());
        SubJobConfig subJobConfig = new ArrayList<>(config.getAllSubJobConfigs()).get(0);
        Assert.assertEquals(SONAR_REPORT_PATH, subJobConfig.getSonarReportPath());
        Assert.assertEquals(PROJECT_PATH, subJobConfig.getProjectPath());
        Assert.assertFalse(subJobConfig.isAutoMatch());
    }

    @Test
    public void testSubJobConfig() {
        InspectionConfig config = new InspectionConfig();
        config.setBaseConfig(null);
        Assert.assertNotNull(config.getBaseConfig());
        Assert.assertEquals(SONAR_REPORT_PATH, config.getBaseConfig().getSonarReportPath());
        Assert.assertEquals(PROJECT_PATH, config.getBaseConfig().getProjectPath());
        Assert.assertEquals(PATH_AUTO_MATCH, config.getBaseConfig().isAutoMatch());
        Assert.assertEquals(PATH_AUTO_MATCH, config.isAutoMatchforPullRequest());

        Assert.assertNotNull(config.getSubJobConfigs());
        Assert.assertEquals(1, config.getSubJobConfigs().size());
        SubJobConfig subJobConfig = new ArrayList<>(config.getSubJobConfigs()).get(0);
        Assert.assertEquals(SONAR_REPORT_PATH, subJobConfig.getSonarReportPath());
        Assert.assertEquals(PROJECT_PATH, subJobConfig.getProjectPath());
        Assert.assertFalse(subJobConfig.isAutoMatch());
    }

    @Test
    public void testProjectConfig() {
        SubJobConfig config = new SubJobConfig();
        Assert.assertEquals(PROJECT_PATH, config.getProjectPath());
        config.setProjectPath(null);
        Assert.assertEquals(PROJECT_PATH, config.getProjectPath());
    }

    //@Test
    public void testAuthenticationConfig() {

    }
}
