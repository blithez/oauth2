// Copyright (C) 2024 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.oauth.gitee;

import static com.google.common.truth.Truth.assertThat;

import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import org.junit.Before;
import org.junit.Test;

public class GiteeApiTest {
  private GiteeApi api;

  @Before
  public void setUp() {
    api = new GiteeApi("https://gitee.com");
  }

  @Test
  public void testAccessTokenExtractor() {
    assertThat(api.getAccessTokenExtractor()).isInstanceOf(OAuth2AccessTokenJsonExtractor.class);
  }

  @Test
  public void testAuthorizationBaseUrl() {
    assertThat(api.getAuthorizationBaseUrl()).isEqualTo("https://gitee.com/oauth/authorize");
  }

  @Test
  public void testAccessTokenEndpoint() {
    assertThat(api.getAccessTokenEndpoint()).isEqualTo("https://gitee.com/oauth/token");
  }
}
