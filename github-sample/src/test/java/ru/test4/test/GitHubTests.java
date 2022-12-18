package ru.test4.test;

import com.google.common.collect.ImmutableBiMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTests {
  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("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");
    RepoCommits commits=github.repos().get(new Coordinates.Simple("temik82","java_test")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableBiMap.Builder<String, String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());
    }

  }
}
