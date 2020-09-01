package radiography.compose

import radiography.ScannableView.ComposeView
import radiography.ViewFilter

@ExperimentalRadiographyComposeApi
public object ComposableFilters {

  /**
   * Filters out Composables with [`testTag`][androidx.compose.ui.platform.testTag] modifiers
   * matching [skippedTestTags].
   */
  @ExperimentalRadiographyComposeApi
  @JvmStatic
  public fun skipTestTagsFilter(vararg skippedTestTags: String): ViewFilter = ViewFilter { view ->
    (view as? ComposeView)
        ?.findTestTags()
        ?.none { it in skippedTestTags }
        ?: true
  }
}
