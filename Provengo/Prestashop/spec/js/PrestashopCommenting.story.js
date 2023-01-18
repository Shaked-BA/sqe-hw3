/* @provengo summon selenium */

/**
 * This story opens a new Prestashop window, goes to a product, and leaves a review as guest.
 */
story('Guest leaves a review for a product', function () {
  with (new SeleniumSession().start('http://localhost:8080/')) {
    goToProduct()
    try
    {
        leaveReview({ title: 'Great Shirt', name: 'David', content: 'Really liked the fabric'})
        OkPopup()
    }
    catch (ex){
    }
  }
})

/**
 * This story opens a new Prestashop window, goes to commenting module, and turns guest commenting off.
 */
story('Admin prevents guest commenting', function () {
  with (new SeleniumSession().start('http://localhost:8080/admin-demo-appendix')) {
    adminLogin({username: 'gadmicha@post.bgu.ac.il', password: 'sqproject3'})
    start('http://localhost:8080/admin-demo-appendix/index.php/improve/modules/manage?_token=aFzsEyGtqiuvN3BjpM8UqhOzyNjZaIqX6dF0ukuQq1o')
//    navigateToModule({module: 'comment'})
    turnOffCommenting()
  }
})

///**
// * This story verifies that if a guest is adding a review while the option to leave a review was turned
//   off by the admin, then the review won't be published.
// */
//story('Guest comment not added because the admin changed the configurations', function () {
//  with (new SeleniumSession().start('https://google.com')) {
//    adminLogin({username: 'gadmicha@post.bgu.ac.il', password: 'sqproject3'})
//    feelLucky()
//  }
//})