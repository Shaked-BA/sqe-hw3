/* @Provengo summon selenium */

/**
 * Useful commands:
 * bp.log.info(e);
 * provengo report <path-to-project>
 * Use of asserts in provengo
 */

/**
 *  The goToProduct event defines the selenium actions for entering a product page.
 */
defineEvent(SeleniumSession, "goToProduct", function(session, e) {
    session.click("//*[@id='content']/section[1]/div/div[1]/article/div/div[1]/a/img");
})

/**
 * The leaveReview event defines the selenium actions for giving a review for a product.
 */
defineEvent(SeleniumSession, "fillReview", function(session, e) {
    session.click("//*[@id='product-comments-list-footer']/button");
    session.writeText("//*[@id='post-product-comment-form']/div[2]/div[1]/input", e.title);
    session.writeText("//*[@id='post-product-comment-form']/div[2]/div[2]/input", e.name);
    session.writeText("//*[@id='post-product-comment-form']/div[4]/div/textarea", e.review);
})

/**
 * The submitReview event defines the selenium actions for submitting of a review.
 */
defineEvent(SeleniumSession, "submitReview", function(session, e) {
    session.click("//*[@id='post-product-comment-form']/div[6]/div[2]/button[2]");
})

/**
 * The adminLogin event defines the selenium actions for admin login to the system.
 */
defineEvent(SeleniumSession, "adminLogin", function(session, e) {
    session.writeText("//*[@id='email']", e.username);
    session.writeText("//*[@id='passwd']", e.password);
    session.click("//*[@id='submit_login']");
})

/**
 * The navigateToModule event defines the selenium actions for reaching a specific module settings.
 */
defineEvent(SeleniumSession, "navigateToModule", function(session, e) {
    session.click("//*[@id='quick_select']")
    session.click("//*[@id='header_quick']/div/ul/li[2]/a")
    session.writeText("//*[@id='search-input-group']/div[1]/div[2]/input", e.module)
    session.click("//*[@id='module-search-button']/i")
})

/**
 * The turnOffCommenting event defines the selenium actions for turning commenting off.
 */
defineEvent(SeleniumSession, "turnOffCommenting", function(session, e) {
    session.click("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/a");
    session.click("//*[@id='PRODUCT_COMMENTS_ALLOW_GUESTS_off']");
    session.click("//*[@id='productcomments_form_submit_btn']")
})