lazy val root = project.in(file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    scriptedBufferLog := false,  // so we can see what's happening
  )
