/* @provengo summon selenium */

// @provengo summon constraints

Constraints.block(Any("EndOfAction").and(Any({eventName: "fillReview"}))).until(Any("EndOfAction").and(Any({eventName: "turnOffCommenting"})));

Constraints.block(Any("EndOfAction").and(Any({eventName: "turnOffCommenting"}))).until(Any("EndOfAction").and(Any({eventName: "navigateToModule"})));

///**
// * This story opens a new Prestashop window, goes to a product, and leaves a review as guest.
// */
//story('Guest leaves a review for a product', function () {
//  with (new SeleniumSession().start('http://localhost:8080/')) {
//    goToProduct();
//    fillReview({ title: 'Great Shirt', name: 'David', review: 'Really liked the fabric'});
//    submitReview();
//    assertAdded();
//  }
//})

/**
 * This story opens a new Prestashop window, goes to commenting module, and turns guest commenting off.
 */
story('Admin prevents guest commenting', function () {
  with (new SeleniumSession().start('http://localhost:8080/admin-demo-appendix')) {
    adminLogin({username: 'gadmicha@post.bgu.ac.il', password: 'sqproject3'});
    navigateToModule({module: 'comment'});
    turnOffCommenting();
    assertSaved();
  }
})

/**
 * This story verifies that if a guest is adding a review while the option to leave a review was turned
   off by the admin, then the review won't be published.
 */
story('Assert comment not added', function () {
  with (new SeleniumSession().start('http://localhost:8080/')) {
    goToProduct();
    fillReview({ title: 'Great Shirt', name: 'David', review: 'Really liked the fabric'});
    submitReview();
    checkAfterSubmission();
    }
})